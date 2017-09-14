import json
import sys
import Node
import C_translation
import parse_forwarding_rules

with open(sys.argv[1]) as data_file:    
    program = json.load(data_file)

forwardingRulesProvided = (len(sys.argv) > 2)
if forwardingRulesProvided:
    forwardingRules = parse_forwarding_rules.parse(sys.argv[2])
else:
    forwardingRules = None

print C_translation.run(Node.NodeFactory(program), forwardingRules)