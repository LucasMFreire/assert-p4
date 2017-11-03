import json
import sys
import Node
import SEFL_translation
import os 
dir_path = os.path.dirname(os.path.realpath(__file__))

with open(sys.argv[1]) as data_file:    
    program = json.load(data_file)

f = open(dir_path + "/seflrunner_skeleton.scala", "r")
contents = f.readlines()
f.close()

contents.insert(25, SEFL_translation.run(Node.NodeFactory(program)))

f = open("SEFLRunner.scala", "w")
contents = "".join(contents)
f.write(contents)
f.close()
