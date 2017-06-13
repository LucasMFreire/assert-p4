import json
import sys
import Node
import C_translation

with open(sys.argv[1]) as data_file:    
    program = json.load(data_file)

print C_translation.run(Node.NodeFactory(program))