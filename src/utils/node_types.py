import sys

node_types = set()

with open(sys.argv[1], 'rU') as f:
  for line in f:
    if "Node_Type" in line:
      node_types.add(line.split("\"")[3])
  for t in node_types:
    print t