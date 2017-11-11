import sys
from collections import defaultdict

def parse(file):

    with open(file) as f:
        content = f.readlines()

    forwardingRules = defaultdict(list)

    for line in content:
        command = line.split()
        ruleComposition = []
        ruleComposition.append(command[0])
        ruleComposition.append(command[2])

        if command[0] == 'table_add':

            keys = []
            keyPosition = 3
            while command[keyPosition] != "=>":
                keys.append(command[keyPosition])
                keyPosition += 1
            ruleComposition.append(keys)

            actionParameters = []
            for paramPosition in range(keyPosition + 1, len(command)):
                actionParameters.append(command[paramPosition])
            ruleComposition.append(actionParameters)

        elif command[0] == 'table_set_default':
            pass
        else:
            print "Error: Unrecognized rule command"

        forwardingRules[command[1]].append(ruleComposition)
    return dict(forwardingRules)

#print parse(sys.argv[1])