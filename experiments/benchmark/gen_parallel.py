import os
import sys

def readfile(fname):
    with open(fname) as file_to_read:
        content = file_to_read.readlines()
        return content

def break_table_action(fname, rules):
    model = readfile(fname)
    table_found = False
    table_comment_line = 0
    call_first_line = 0
    call_last_line = 0
    filenames = []
    conditions = []
    for idx, line in enumerate(model):
        if "//Table" in line:
            table_comment_line = idx
            table_found = True
            call_first_line = idx + 2
        if not rules:
            if table_found and "switch" in line:
                variable_in_switch = line[line.find("(")+1:line.find(")")]
                actions = []
                idx += 1
                while "}" not in model[idx]:
                    case = model[idx].split(":")
                    action = case[1].split(";")[0]
                    actions.append(action)
                    idx += 1
                    call_last_line = idx
                for i, action in enumerate(actions):
                    filename = fname.split(".")[0] + "_table_" + str(i) + ".c"
                    filenames.append(filename)
                    with open( filename, 'w') as new_model:
                        call_added = False
                        for ln, l in enumerate(model):
                            if not (ln >= call_first_line and ln <= call_last_line):
                                new_model.write(l)
                            elif not call_added:
                                new_model.write(action + ";\n")
                                call_added = True
                return filenames
        else:
            if table_found and "if" in line:
                variable_in_if = line[line.find("(")+1:line.find(")")]
                conditions.append(variable_in_if)
            elif table_found and line == "}\n":
                for i, condition in enumerate(conditions):
                        assume = "klee_assume(" + condition + ");\n"
                        filename = fname.split(".")[0] + "_table_" + str(i) + ".c"
                        filenames.append(filename)
                        with open(filename, 'w') as new_model:
                            for ln, l in enumerate(model):
                                if ln == table_comment_line + 2:
                                    new_model.write(assume)
                                new_model.write(l)
                assume = ""            
                for condition in conditions:
                    assume += "klee_assume(!(" + condition + "));\n"
                filename = fname.split(".")[0] + "_table_" + str(i+1) + ".c"
                filenames.append(filename)
                with open(filename, 'w') as new_model:
                    for ln, l in enumerate(model):
                        if ln == table_comment_line + 2:
                            new_model.write(assume)
                        new_model.write(l)
                return filenames

def break_parser_transition(fname, switch):
    model = readfile(fname)
    parser_found = False
    parser_line = 0
    transition_first_line = 0
    transition_last_line = 0
    filenames = []
    conditions = []
    for idx, line in enumerate(model):
        if "parse_" in line and " {" in line and not parser_found:
            parser_line = idx
            parser_found = True
        if not switch:
            if parser_found and "if" in line:
                variable_in_if = line[line.find("(")+2:line.find(")")]
                conditions.append(variable_in_if)
            elif parser_found and "else" in line:
                for i, condition in enumerate(conditions):
                        assume = "klee_assume(" + condition + ");\n"
                        filename = fname.split(".")[0] + "_parser_" + str(i) + ".c"
                        filenames.append(filename)
                        with open(filename, 'w') as new_model:
                            for ln, l in enumerate(model):
                                if ln == parser_line + 1:
                                    new_model.write(assume)
                                new_model.write(l)
                assume = ""            
                for condition in conditions:
                    assume += "klee_assume(!(" + condition + "));\n"
                filename = fname.split(".")[0] + "_parser_" + str(i+1) + ".c"
                filenames.append(filename)
                with open(filename, 'w') as new_model:
                    for ln, l in enumerate(model):
                        if ln == parser_line + 1:
                            new_model.write(assume)
                        new_model.write(l)
                return filenames
        else:
            if parser_found and "switch" in line:
                transition_first_line = idx
                variable_in_switch = line[line.find("(")+1:line.find(")")]
                condition_state = []
                idx += 1
                while "}" not in model[idx]:
                    case = model[idx].split(":")
                    condition = case[0].split(" ")[-1]
                    state = case[1].split(";")[0]
                    condition_state.append([condition, state])
                    idx += 1
                    transition_last_line = idx
                for i, condition in enumerate(condition_state):
                    assume = ""
                    if "default" not in condition[0]:
                        assume = "klee_assume(" + variable_in_switch + " == " + condition[0] + ");\n"
                    else:
                        for condition_neg in condition_state:
                            if "default" not in condition_neg[0]:
                                assume += "klee_assume(" + variable_in_switch + " != " + condition_neg[0] + ");\n"
                    state = condition[1] + ";\n"
                    filename = fname.split(".")[0] + "_parser_" + str(i) + ".c"
                    filenames.append(filename)
                    with open(filename, 'w') as new_model:
                        transition_added = False
                        for ln, l in enumerate(model):
                            if not (ln >= transition_first_line and ln <= transition_last_line):
                                new_model.write(l)
                            elif not transition_added:
                                new_model.write(assume)
                                new_model.write(state)
                                transition_added = True
                return filenames

def gen_parallel(filename, switch, rules):
    NCORES = 4
    fnames = break_parser_transition(filename, switch)
    while len(fnames) < NCORES:
        newfnames = []
        for fname in fnames:
            asd = break_table_action(fname, rules)
            newfnames += asd
        fnames = newfnames
        if len(fnames) < NCORES:
            for fname in fnames:
                print len(fnames)
                newfnames += break_parser_transition(fname, switch)
        fnames = newfnames
    return fnames
