import json
import sys
import Node
import Translations

with open(sys.argv[1]) as data_file:    
    program = json.load(data_file)

Translations.toSEFL(Node.NodeFactory(program))