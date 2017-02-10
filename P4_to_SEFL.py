import json
from collections import namedtuple

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
                

def toSEFL(node):
    print str(node.Node_ID) + ": " + node.Node_Type
    if node.Node_Type == 'P4Program':
        toSEFL(node.declarations) 
    elif node.Node_Type == 'IndexedVector<Node>':
        for v in node.vec:
            toSEFL(v)
    elif node.Node_Type == 'P4Control':
        toSEFL(node.type.applyParams)
        toSEFL(node.controlLocals)
        toSEFL(node.body) 
    elif node.Node_Type == 'BlockStatement':
        toSEFL(node.components)
    elif node.Node_Type == 'ActionList':
        pass 
    elif node.Node_Type == 'ActionListElement':
        pass
    elif node.Node_Type == 'Annotation':
        pass
    elif node.Node_Type == 'Annotations':
        pass
    elif node.Node_Type == 'AssignmentStatement':
        print "Assign('" + str(toSEFL(node.left)) + "', " + str(toSEFL(node.right)) + ")"  
    elif node.Node_Type == 'Constant':
        return node.value
    elif node.Node_Type == 'ConstructorCallExpression':
        pass
    elif node.Node_Type == 'Declaration_Instance':
        pass
    elif node.Node_Type == 'Declaration_Variable':
        print "Allocate('" + node.name + "', " + str(node.type.size) + ")"
    elif node.Node_Type == 'ExpressionValue':
        toSEFL(node.expression) 
    elif node.Node_Type == 'Member':
        toSEFL(node.expr)
    elif node.Node_Type == 'MethodCallExpression':
        toSEFL(node.method)
    elif node.Node_Type == 'MethodCallStatement':
        toSEFL(node.methodCall)
    elif node.Node_Type == 'NameMap<Property>':
        pass    
    elif node.Node_Type == 'P4Action':
        toSEFL(node.body)
    elif node.Node_Type == 'P4Table':
        toSEFL(node.properties)
    elif node.Node_Type == 'Parameter':
        print "Allocate('" + node.name + "', " + str(node.type.size) + ")"
    elif node.Node_Type == 'ParameterList':
        toSEFL(node.parameters)
    elif node.Node_Type == 'Path':
        return node.name
    elif node.Node_Type == 'PathExpression':
        return toSEFL(node.path)
    elif node.Node_Type == 'Property':
        toSEFL(node.value)
    elif node.Node_Type == 'StringLiteral':
        pass
    elif node.Node_Type == 'StructField':
        print "Allocate('" + node.name + "', " + str(node.type.size) + ")"
    elif node.Node_Type == 'TableProperties':
        toSEFL(node.properties)
    elif node.Node_Type == 'TypeParameters':
        pass
    elif node.Node_Type == 'Type_Action':
        pass
    elif node.Node_Type == 'Type_ActionEnum':
        pass
    elif node.Node_Type == 'Type_Control':
        pass
    elif node.Node_Type == 'Type_Method':
        pass
    elif node.Node_Type == 'Type_Name':
        pass
    elif node.Node_Type == 'Type_Package':
        pass
    elif node.Node_Type == 'Type_Struct':
        pass
    elif node.Node_Type == 'Type_Table':
        toSEFL(node.table)
    elif node.Node_Type == 'Type_Unknown':
        pass
    elif node.Node_Type == 'Type_Error':
        pass
    elif node.Node_Type == 'Type_Extern':
        pass
    elif node.Node_Type == 'Declaration_MatchKind':
        pass
    elif node.Node_Type == 'Type_Header':
        toSEFL(node.fields)
    elif node.Node_Type == 'P4Parser':
        toSEFL(node.states)
    elif node.Node_Type == 'Type_Parser':
        pass
    elif node.Node_Type == 'ParserState':
        toSEFL(node.components) 
    elif 'IndexedVector' in node.Node_Type:
        for v in node.vec:
            toSEFL(v) 
    else:
        raise ValueError('Unknown node type: ' + node.Node_Type)

with open('data.json') as data_file:    
    program = json.load(data_file)

toSEFL(NodeFactory(program))

