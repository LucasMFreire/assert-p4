
blocks = []

def run(node):
    returnString = ""
    program = toSEFL(node)
    for block in blocks:
        returnString = returnString + block
    returnString = returnString + program 
    return returnString
    

def toSEFL(node):
    #print str(node.Node_ID) + ": " + node.Node_Type
    if 'Vector' in node.Node_Type:
        returnString = ""
        for v in node.vec:
            returnString = returnString + toSEFL(v) + "\n"
        return returnString
    else:
        return globals()[node.Node_Type](node) #calls corresponding type function according to node type

########### TYPE FUNCTIONS ###########

def P4Program(node):
    return toSEFL(node.declarations)

def P4Control(node):
    returnString = ""
    returnString = returnString + toSEFL(node.type.applyParams)
    returnString = returnString + toSEFL(node.controlLocals)
    returnString = returnString + toSEFL(node.body)
    return returnString

def BlockStatement(node):
    blockName = "block" + str(node.Node_ID)
    components = ""
    for v in node.components.vec:
        components = components + "\t" + toSEFL(v) + ",\n"
    components = components[:-2]
    block = "val " + blockName + " = InstructionBlock(\n" + components + "\n)\n\n"
    blocks.append(block)
    return blockName

def ActionList(node):
    return "<ActionList>" + str(node.Node_ID) + "\n" 

def ActionListElement(node):
    return "<ActionListElement>" + str(node.Node_ID) + "\n" 

def Add(node):
    return add(node)

def Annotation(node):
    return "<Annotation>" + str(node.Node_ID) + "\n" 

def Annotations(node):
    return "<Annotations>" + str(node.Node_ID) + "\n" 

def ArrayIndex(node):
    return "<ArrayIndex>" + str(node.Node_ID) + "\n" 

def AssignmentStatement(node):
    return assign(node)

def BoolLiteral(node):
    return node.value

def Constant(node):
    return "ConstantValue(" + str(node.value) + ")"

def ConstructorCallExpression(node):
    return "<ConstructorCallExpression>" + str(node.Node_ID) + "\n" 

def Declaration_Instance(node):
    return "<Declaration_Instance>" + str(node.Node_ID) + "\n" 

def Declaration_Variable(node):
    return allocate(node)

def EmptyStatement(node):
    return "<EmptyStatement>" + str(node.Node_ID) + "\n"

def ExpressionValue(node):
    return toSEFL(node.expression) 

def Grt(node):
    return greater(node)

def IfStatement(node):
    return ifStatement(node)

def LNot(node):
    return "!" + toSEFL(node.expr)

def Member(node):
    return toSEFL(node.expr)

def Method(node):
    return toSEFL(node.type)

def MethodCallExpression(node):
    return toSEFL(node.method)

def MethodCallStatement(node):
    return toSEFL(node.methodCall)

def NameMapProperty(node):
    return "<NameMapProperty>" + str(node.Node_ID) + "\n"

def P4Action(node):
    return "val action_" + str(node.name) + " = InstructionBlock(\n\t" + toSEFL(node.body) + ")\n\n"

def P4Table(node):
    return toSEFL(node.properties)

def Parameter(node):
    return allocate(node)

def ParameterList(node):
    return toSEFL(node.parameters)

def Path(node):
    return node.name

def PathExpression(node):
    return toSEFL(node.path)

def Property(node):
    return toSEFL(node.value)

def SelectExpression(node):
    expressions = node.select.components.vec
    exp = []
    for expression in expressions:
        if  expression.method.member == "isValid":
            exp.append("validityBit_" + expression.method.expr.path.name)

    cases = node.selectCases.vec
    returnString = ""
    for case in cases:
        returnString = returnString + "If(" + str(exp[0]) + " == " + str(case.keyset.value) + ", " + case.state.path.name + "),\n\t"
    return returnString

def StringLiteral(node):
    return "<StringLiteral>" + str(node.Node_ID) + "\n"

def StructField(node):
    return allocate(node)

def SwitchCase(node):
    return toSEFL(node.statement)

def SwitchStatement(node):
    switchCases = toSEFL(node.cases).replace("\n", ",")
    returnString = "Fork(InstructionBlock(), " + switchCases[:-1] + ")"
    return returnString

def TableProperties(node):
    return toSEFL(node.properties)

def TypeParameters(node):
    return "<TypeParameters>" + str(node.Node_ID) + "\n"

def Type_Action(node):
    return "<Type_Action>" + str(node.Node_ID) + "\n"

def Type_ActionEnum(node):
    return "<Type_ActionEnum>" + str(node.Node_ID) + "\n"

def Type_Control(node):
    return "<Type_Control>" + str(node.Node_ID) + "\n"

def Type_Method(node):
    return "<Type_Method>" + str(node.Node_ID) + "\n"

def Type_Name(node):
    return "<Type_Name>" + str(node.Node_ID) + "\n"

def Type_Package(node):
    return "<Type_Package>" + str(node.Node_ID) + "\n"

def Type_Struct(node):
    return "<Type_Struct>" + str(node.Node_ID) + "\n"

def Type_Table(node):
    return toSEFL(node.table)

def Type_Unknown(node):
    return "<Type_Unknown>" + str(node.Node_ID) + "\n"

def Type_Error(node):
    return "<Type_Error>" + str(node.Node_ID) + "\n"

def Type_Extern(node):
    return "<Type_Extern>" + str(node.Node_ID) + "\n"

def Declaration_MatchKind(node):
    return "<Declaration_MatchKind>" + str(node.Node_ID) + "\n"

def Type_Header(node):
    validityBit = "Allocate('validityBit_" + node.name + "', 1),\n"
    setValidityBitToFalse = "Assign('validityBit_" + node.name + "', False),\n"
    return validityBit + setValidityBitToFalse + toSEFL(node.fields)

def P4Parser(node):
    returnString = ""
    returnString = returnString + toSEFL(node.parserLocals)
    returnString = returnString + toSEFL(node.states)
    return returnString 

def Type_Enum(node):
    return "<Type_Enum>" + str(node.Node_ID) + "\n"

def Type_Parser(node):
    return "<Type_Parser>" + str(node.Node_ID) + "\n"

def ParserState(node):
    components = ""
    for v in node.components.vec:
        components = components + "\t" + toSEFL(v) + ",\n"
    parser = "val " + node.name + " = InstructionBlock(\n" + components + "\t" + toSEFL(node.selectExpression) + "\n)\n\n"
    return parser


    returnString = "val parserState_" + node.name + " = InstructionBlock(\n" + toSEFL(node.components) + ")\n"
    return returnString

########### HELPER FUNCTIONS ###########

def ifStatement(node):
    return "If(" + str(toSEFL(node.condition)) + ", " + str(toSEFL(node.ifTrue)) + ", " + str(toSEFL(node.ifFalse)) + ")"

def greater(node):
    return str(toSEFL(node.left)) + " > " + str(toSEFL(node.right))

def add(node):
    return str(toSEFL(node.left)) + " + " + str(toSEFL(node.right))

def allocate(node):
    returnString = ""
    if node.type.Node_Type == 'Type_Bits':
        returnString = "Allocate('" + node.name + "', " + str(node.type.size) + ")"
    elif node.type.Node_Type == 'Type_Boolean':
        returnString = "Allocate('" + node.name + "', 1)" #assuming boolean size is 1 bit
    elif node.type.Node_Type == 'Type_Name':
        pass
    elif node.type.Node_Type == 'Type_Stack':
        returnString = "// " + str(node.type.elementType.path.name) + "[" + str(node.type.size.value) + "] " + str(node.name)
    else:
        raise ValueError('Allocating unknown node type: ' + node.type.Node_Type)
    return returnString

def assign(node):
    return "Assign('" + str(toSEFL(node.left)) + "', " + str(toSEFL(node.right)) + ")"
