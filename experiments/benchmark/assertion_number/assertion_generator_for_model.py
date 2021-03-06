
def generateTraverse(content, numberOfAssertions):
    with open("traverse_tests/main_model_" + str(numberOfAssertions) + ".c", 'w+') as f:
        for i,line in enumerate(content):
            if "int action_run;" in line:
                for x in range(0, numberOfAssertions):
                    f.write('\nint path_' + str(x) + " = 0;\n")
            elif "standard_metadata.egress_spec = port;" in line:
                for x in range(0, numberOfAssertions):
                    f.write('\n\tpath_' + str(x) + " = 1;\n")
            elif "//Emit hdr.ethernet" in line:
                for x in range(0, numberOfAssertions):
                    f.write('\tif(!path_' + str(x) + ") { printf(\"assertion error: traverse_path\"); }\n")
            f.write(line)

def generateEquality(content, numberOfAssertions):
    with open("equality_tests/main_model_" + str(numberOfAssertions) + ".c", 'w+') as f:
        for i,line in enumerate(content):
            if "standard_metadata.egress_spec = port;" in line:
                for x in range(0, numberOfAssertions):
                    f.write("\tif(!(hdr.ipv4.ttl != 0)) { printf(\"assertion error: hdr.ipv4.ttl != 0\"); }\n")
            f.write(line)

def generateFakeEquality(content, numberOfAssertions):
    with open("symbolic_equality_tests/main_model_fake_vars" + str(numberOfAssertions) + ".c", 'w+') as f:
        for i,line in enumerate(content):
            if "standard_metadata.egress_spec = port;" in line:
                for x in range(0, numberOfAssertions):
                    varname = "hdr.ipv4.fake_var_" + str(x)
                    f.write("\tif(!(" + varname + " != 0)) { printf(\"assertion error: " + varname + " != 0\"); }\n")
            f.write(line)

def generateFakeVarsFile(content, numberOfAssertions):
    with open("main_model_fake_vars.c", 'w+') as f:
        for i,line in enumerate(content):
            if "} ipv4_t;" in line:
                for x in range(0, numberOfAssertions):
                    f.write("\tuint32_t fake_var_" + str(x) + " : 32;\n")
            f.write(line)

numberOfAssertions = 200
with open("main_model.c") as f:
    content = f.readlines()
generateFakeVarsFile(content, numberOfAssertions)
with open("main_model_fake_vars.c") as f:
    contentFake = f.readlines()
for x in range(0, numberOfAssertions):
    generateTraverse(content, x)
    generateEquality(content, x)
    generateFakeEquality(contentFake, x)