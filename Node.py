
allNodes = {}

def NodeFactory(node):
    nodeId = node.get('Node_ID', None)
    if nodeId is not None:
        Node(node) #must create node even if it exists to process new attributes
        return allNodes[nodeId]
    else:
       return Node(node)

class Node(object):

    def __init__(self, node):
        
        #if node already exists, reference it instead of self
        updateNode = self
        nodeId = node.get('Node_ID', None)
        if nodeId is not None:
            if nodeId not in allNodes:
                allNodes[nodeId] = self
            updateNode = allNodes[nodeId]
        
        #update node value for each attribute
        for k in node.keys():
            if isinstance(node[k], dict):
                setattr(updateNode, k, NodeFactory(node[k]))
            elif isinstance(node[k], list):
                l = []
                for item in node[k]:
                    l.append(NodeFactory(item))
                setattr(updateNode, k, l)
            else:
                setattr(updateNode, k, node[k])