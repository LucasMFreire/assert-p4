import json
import sys
import Node

frozenVariables = set()

def P4Program(node):
    return analyze(node.declarations)

def P4Control(node):
    analyze(node.type.applyParams)
    analyze(node.controlLocals)
    return analyze(node.body)

def BlockStatement(node):
    analyze(node.annotations)
    return analyze(node.components)

def ActionList(node):
    pass

def ActionListElement(node):
    pass

def Add(node):
    pass

def Annotation(node):
    if "PHI_freeze_" in node.name:
        variableName = node.name[11:]
        print "::: frozen variable: " + variableName
        frozenVariables.add(variableName)

def Annotations(node):
    return analyze(node.annotations) 

def ArrayIndex(node):
    pass

def AssignmentStatement(node):
    lvalue = str(analyze(node.left))
    if lvalue in frozenVariables:
        print "/!\ INTEGRITY VIOLATION DETECTION: " + str(node.Node_ID) + " - " + lvalue 

def BoolLiteral(node):
    pass

def Constant(node):
    pass

def ConstructorCallExpression(node):
    pass

def Declaration_Instance(node):
    pass

def Declaration_Variable(node):
    pass

def EmptyStatement(node):
    pass

def ExpressionValue(node):
    return analyze(node.expression) 

def Grt(node):
    pass

def IfStatement(node):
    pass

def LNot(node):
    return analyze(node.expr)

def Member(node):
    return analyze(node.expr)

def Method(node):
    return analyze(node.type)

def MethodCallExpression(node):
    return analyze(node.method)

def MethodCallStatement(node):
    return analyze(node.methodCall)

def NameMapProperty(node):
    pass

def P4Action(node):
    return analyze(node.body)

def P4Table(node):
    return analyze(node.properties)

def Parameter(node):
    pass

def ParameterList(node):
    return analyze(node.parameters)

def Path(node):
    return node.name

def PathExpression(node):
    return analyze(node.path)

def Property(node):
    return analyze(node.value)

def StringLiteral(node):
    pass

def StructField(node):
    pass

def SwitchCase(node):
    analyze(node.label)
    return analyze(node.statement)

def SwitchStatement(node):
    analyze(node.expression)
    return analyze(node.cases)

def TableProperties(node):
    return analyze(node.properties)

def TypeParameters(node):
    pass

def Type_Action(node):
    pass

def Type_ActionEnum(node):
    pass

def Type_Control(node):
    pass

def Type_Method(node):
    pass

def Type_Name(node):
    pass

def Type_Package(node):
    pass

def Type_Struct(node):
    pass

def Type_Table(node):
    return analyze(node.table)

def Type_Unknown(node):
    pass

def Type_Error(node):
    pass

def Type_Extern(node):
    pass

def Declaration_MatchKind(node):
    pass

def Type_Header(node):
    return analyze(node.fields)

def P4Parser(node):
    analyze(node.parserLocals)
    return analyze(node.states) 

def Type_Enum(node):
    pass

def Type_Parser(node):
    pass

def ParserState(node):
    return analyze(node.components)

####################################################################
####################################################################

def analyze(node):
    #print str(node.Node_ID) + ": " + node.Node_Type
    if 'Vector' in node.Node_Type:
        for v in node.vec:
            analyze(v)
    else:
        return globals()[node.Node_Type](node) #calls corresponding type function according to node type


with open(sys.argv[1]) as data_file:    
    program = json.load(data_file)

analyze(Node.NodeFactory(program))