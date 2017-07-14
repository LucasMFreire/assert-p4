
def generateActions(content, numberOfActions):
    with open("action_tests/main_model_" + str(numberOfActions) + ".c", 'w+') as f:
        for i,line in enumerate(content):
            for x in range(0, numberOfActions):
                naction = "9999" + str(x)
                if "void NoAction_0_102637() " in line:
                    f.write("\nvoid fakeAction_" + naction + "() {	action_run = "+ naction + "; }\n")
                elif "default: NoAction_" in line:
                    f.write("case " + str(x + 1) + ": fakeAction_" + naction + "(); break;\n")
                elif "void parse_tcp();" in line:
                    f.write("void fakeAction_" + naction + "();\n")
            f.write(line)

numberOfActions = 200
with open("main_model.c") as f:
    content = f.readlines()
for x in range(0, numberOfActions):
    generateActions(content, x)