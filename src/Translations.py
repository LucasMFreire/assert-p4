
def toSEFL(node):
    print str(node.Node_ID) + ": " + node.Node_Type
    if 'IndexedVector' in node.Node_Type:
        for v in node.vec:
            toSEFL(v)
    else:
        return globals()[node.Node_Type](node) #calls corresponding type function according to node type

########### TYPE FUNCTIONS ###########

def P4Program(node):
    toSEFL(node.declarations) 

def P4Control(node):
    toSEFL(node.type.applyParams)
    toSEFL(node.controlLocals)
    toSEFL(node.body) 

def BlockStatement(node):
    toSEFL(node.components)

def ActionList(node):
    pass 

def ActionListElement(node):
    pass

def Annotation(node):
    pass

def Annotations(node):
    pass

def AssignmentStatement(node):
    assign(node)

def Constant(node):
    return node.value

def ConstructorCallExpression(node):
    pass

def Declaration_Instance(node):
    pass

def Declaration_Variable(node):
    allocate(node)

def ExpressionValue(node):
    toSEFL(node.expression) 

def Member(node):
    toSEFL(node.expr)

def MethodCallExpression(node):
    toSEFL(node.method)

def MethodCallStatement(node):
    toSEFL(node.methodCall)

def NameMapProperty(node):
    pass    

def P4Action(node):
    toSEFL(node.body)

def P4Table(node):
    toSEFL(node.properties)

def Parameter(node):
    allocate(node)

def ParameterList(node):
    toSEFL(node.parameters)

def Path(node):
    return node.name

def PathExpression(node):
    return toSEFL(node.path)

def Property(node):
    toSEFL(node.value)

def StringLiteral(node):
    pass

def StructField(node):
    allocate(node)

def TableProperties(node):
    toSEFL(node.properties)

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
    toSEFL(node.table)

def Type_Unknown(node):
    pass

def Type_Error(node):
    pass

def Type_Extern(node):
    pass

def Declaration_MatchKind(node):
    pass

def Type_Header(node):
    toSEFL(node.fields)

def P4Parser(node):
    toSEFL(node.states)

def Type_Enum(node):
    pass

def Type_Parser(node):
    pass

def ParserState(node):
    toSEFL(node.components) 

########### HELPER FUNCTIONS ###########

def allocate(node):
    if node.type.Node_Type == 'Type_Bits':
        print "Allocate('" + node.name + "', " + str(node.type.size) + ")"
    elif node.type.Node_Type == 'Type_Name':
        pass
    else:
        raise ValueError('Allocating unknown node type: ' + node.type.Node_Type)

def assign(node):
    print "Assign('" + str(toSEFL(node.left)) + "', " + str(toSEFL(node.right)) + ")"  