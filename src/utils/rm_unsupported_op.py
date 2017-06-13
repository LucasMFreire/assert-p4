import sys


with open(sys.argv[1], 'rU') as f:
  for line in f:
    if "<" not in line:
        print line