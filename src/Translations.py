
blocks = []
headers = []
structFieldsHeaderTypes = {}
headerStackSize = {}
currentPacketAllocationPosition = 0

def run(node):
    returnString = ""
    program = toSEFL(node)
    for block in blocks:
        returnString += block
    returnString += program 
    return returnString
    

def toSEFL(node):
    #print str(node.Node_ID) + ": " + node.Node_Type
    if 'Vector' in node.Node_Type:
        returnString = ""
        for v in node.vec:
            returnString += toSEFL(v) + "\n"
        return returnString
    else:
        return globals()[node.Node_Type](node) #calls corresponding type function according to node type

########### TYPE FUNCTIONS ###########

def P4Program(node):
    return toSEFL(node.declarations)

def P4Control(node):
    returnString = ""
    returnString += toSEFL(node.type.applyParams)
    returnString += toSEFL(node.controlLocals)
    returnString += toSEFL(node.body)
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

def BOr(node):
    return "<BOr>" + str(node.Node_ID)

def BXor(node):
    return "<BXor>" + str(node.Node_ID)

def Cast(node):
    return "<Cast>" + str(node.Node_ID)

def LAnd(node):
    return "<LAnd>" + str(node.Node_ID)

def LOr(node):
    return "<LOr>" + str(node.Node_ID)

def Slice(node):
    return "<Slice>" + str(node.Node_ID)

def Shl(node):
    return "<Shl>" + str(node.Node_ID)

def ActionList(node):
    #assuming every action will be forked
    returnString = "\tFork("
    for action in node.actionList.vec:
        if action.expression.Node_Type == "PathExpression":
            returnString += action.expression.path.name + ", "
        elif action.expression.Node_Type == "MethodCallExpression":
            returnString += action.expression.method.path.name + ", "
        else:
            returnString += "ERROR:UNKNOWN ACTION LIST TYPE"
    return returnString[:-2] + ")"

def ActionListElement(node):
    return "<ActionListElement>" + str(node.Node_ID) 

def Add(node):
    return add(node)

def Sub(node):
    return sub(node)

def Annotation(node):
    return "<Annotation>" + str(node.Node_ID) 

def Annotations(node):
    return "<Annotations>" + str(node.Node_ID) 

def ArrayIndex(node):
    return toSEFL(node.left) + "_" + str(node.right.value)

def AssignmentStatement(node):
    return assign(node)

def BoolLiteral(node):
    if node.value == "true":
        return "ConstantValue(1)"
    else:
        return "ConstantValue(0)"

def Constant(node):
    return "ConstantValue(" + str(node.value) + ")"

def ConstructorCallExpression(node):
    return "<ConstructorCallExpression>" + str(node.Node_ID) 

def Declaration_Instance(node):
    return "<Declaration_Instance>" + str(node.Node_ID) 

def Declaration_Variable(node):
    if  node.type.Node_Type == 'Type_Name':
        returnString = ""
        for header in headers:
            if header[0] == node.type.path.name:
                returnString += "Allocate('validityBit_" + node.name + "'),\n"
                returnString += "Assign('validityBit_" + node.name + "', ConstantValue(0)),\n"
                for field in header[1]:
                    returnString += "Allocate('" + field.name + "_" + node.name + "'),"
        return returnString
    return allocate(node)

def EmptyStatement(node):
    return "<EmptyStatement>" + str(node.Node_ID)

def Neq(node):
    return "<Neq>" + str(node.Node_ID)

def Equ(node):
    return "<Equ>" + str(node.Node_ID)

def ExpressionValue(node):
    return toSEFL(node.expression) 

def Grt(node):
    return greater(node)

def IfStatement(node):
    return ifStatement(node)

def Key(node):
    returnString = "\t// keys: "
    for key in node.keyElements.vec:
            returnString += toSEFL(key.expression) + ", "
    return returnString[:-2]

def LNot(node):
    return "!" + toSEFL(node.expr)

def Member(node):
    if node.member != 'apply':
        return toSEFL(node.expr) + "." + node.member
    else:
        return toSEFL(node.expr)

def Method(node):
    return toSEFL(node.type)

def MethodCallExpression(node):
    returnString = ""
    # extract method
    if hasattr(node.method, 'member') and node.method.member == "extract":
        headerToExtract = toSEFL(node.arguments.vec[0])
        returnString += "// extract " + headerToExtract + "\n"
        for header in headers:
            # header stack position
            if node.arguments.vec[0].Node_Type == "ArrayIndex":
                if header[0] == getHeaderType(node.arguments.vec[0].left.member):
                    headerToExtract = node.arguments.vec[0].left.expr.path.name
                    returnString += "\tAssign('" + headerToExtract + ".isValid', ConstantValue(1)),\n"
                    for field in header[1]:
                        returnString += "\tAssign('" + headerToExtract + "." + "_" + str(node.arguments.vec[0].right.value) + field.name + "', SymbolicValue()),\n"
            # next header stack element
            elif node.arguments.vec[0].member == "next":
                if header[0] == getHeaderType(node.arguments.vec[0].expr.member):
                    hdr = headerToExtract.split(".")[1] #remove next keyword
                    for i in range(0, headerStackSize[hdr]):
                        returnString += "\tIf('" + hdr + "Index', :==:(ConstantValue(" + str(i) + ")),\n\t\tinstructionBlock(\n"
                        returnString += "\t\t\tAssign('" + hdr +  "_" + str(i) + ".isValid" + "', ConstantValue(1)),\n"
                        for field in header[1]:
                            returnString += "\t\t\tAssign('" + hdr + "_" + str(i) + "." + field.name + "', SymbolicValue()),\n"
                        returnString = returnString[:-2]
                        returnString += "),\n"  
                    returnString = returnString[:-2] 
                    for i in range(0, headerStackSize[hdr]):
                        returnString += ")"
                    returnString += ",\n\tAssign('" + hdr + "Index', :+:('" + hdr + "Index',ConstantValue(1))),\n"
            #regular header field
            elif header[0] == getHeaderType(node.arguments.vec[0].member):
                returnString += "\tAssign('" + headerToExtract + ".isValid', ConstantValue(1)),\n"
                for field in header[1]:
                    returnString += "\tAssign('" + headerToExtract + "." + field.name + "', SymbolicValue()),\n"
        returnString = returnString[:-2]
    # emit method
        # if ...
    # extern method: Name it as extern for later processing
    elif hasattr(node.method, 'expr') and node.method.expr.type.Node_Type == "Type_Extern":
        returnString =  "//Extern: " + toSEFL(node.method)
    #verify method
    elif hasattr(node.method, 'path') and node.method.path.name == "verify":
        returnString += "If(Constrain('" + node.arguments.vec[0].path.name + "', :==:(ConstantValue(0))), Fail('" + node.arguments.vec[1].member + "')"
     #SetValid method
    elif hasattr(node.method, 'member') and node.method.member == "setValid":
        returnString += "Assign('" + toSEFL(node.method.expr) + ".isValid', ConstantValue(1))"
     #SetInvalid method
    elif hasattr(node.method, 'member') and node.method.member == "setInvalid":
        returnString += "Assign('" + toSEFL(node.method.expr) + ".isValid', ConstantValue(0))"
    else:
        returnString = toSEFL(node.method)
    return returnString

def MethodCallStatement(node):
    return toSEFL(node.methodCall)

def NameMapProperty(node):
    return "<NameMapProperty>" + str(node.Node_ID)

def P4Action(node):
    actionData = ""
    for param in node.parameters.parameters.vec:
        if param.direction == "":
            actionData += "Assign('" + param.name + "', SymbolicValue()),\n\t"
    return "// Action\nval " + str(node.name) + " = InstructionBlock(\n\t" + actionData + toSEFL(node.body) + "\n)\n\n"

def P4Table(node):
    return "//Table\nval " + str(node.name) + " = InstructionBlock(\n" + toSEFL(node.properties) + ")\n\n"

def Parameter(node):
    return allocate(node)

def ParameterList(node):
    return toSEFL(node.parameters)

def Path(node):
    return node.name

def PathExpression(node):
    return toSEFL(node.path)

def Property(node):
    if node.name == "default_action":
        return "\t// default_action " + toSEFL(node.value)
    elif node.name == "size":
        return "\t// size " + toSEFL(node.value)
    else:
        return toSEFL(node.value)

def SelectExpression(node):
    expressions = node.select.components.vec
    exp = []
    for expression in expressions:
        if expression.Node_Type == 'Slice':
            #TODO: slice bit string currently not supported #bitop
            return ""
        if expression.Node_Type == 'Member':
            exp.append(expression.member + "_" + toSEFL(expression.expr))
        if  expression.Node_Type == "MethodCallStatement":
            if expression.method.member == "isValid":
                exp.append("validityBit_" + expression.method.expr.path.name)

    cases = node.selectCases.vec
    returnString = ""
    for case in cases:
        if case.keyset.Node_Type == 'Mask':
            #todo: fix mask #bitop
            returnString = "//TODO: MASK"
        elif case.keyset.Node_Type == 'DefaultExpression':
            returnString += case.state.path.name + ")\n\t"
        elif case.keyset.Node_Type == 'Constant':
            returnString += "If(" + str(exp[0]) + " == " + str(case.keyset.value) + ", " + case.state.path.name + ",\n\t"
    #close with ) according to cases length
    return returnString

def StringLiteral(node):
    return "<StringLiteral>" + str(node.Node_ID)

def StructField(node):
    returnString = ""
    #warning: two headers defined in different structs
    #with the same name but different types would break this
    #future solution: discriminate by struct name
    if  node.type.Node_Type == "Type_Name":
        structFieldsHeaderTypes[node.name] = node.type.path.name
    if  node.type.Node_Type == "Type_Stack":
        structFieldsHeaderTypes[node.name] = node.type.elementType.path.name
        headerStackSize[node.name] = node.type.size.value
        returnString += ",\nAllocate('" + node.name + "Index')" 
    return returnString

def SwitchCase(node):
    return toSEFL(node.statement)

def SwitchStatement(node):
    switchCases = toSEFL(node.cases).replace("\n", ",")
    returnString = "Fork(InstructionBlock(), " + switchCases[:-1] + ")"
    return returnString

def TableProperties(node):
    return toSEFL(node.properties)

def TypeParameters(node):
    return "<TypeParameters>" + str(node.Node_ID)

def Type_Action(node):
    return "<Type_Action>" + str(node.Node_ID)

def Type_ActionEnum(node):
    return "<Type_ActionEnum>" + str(node.Node_ID)

def Type_Control(node):
    return "<Type_Control>" + str(node.Node_ID)

def Type_Method(node):
    return "<Type_Method>" + str(node.Node_ID)

def Type_Name(node):
    return "<Type_Name>" + str(node.Node_ID)

def Type_Package(node):
    return "<Type_Package>" + str(node.Node_ID)

def Type_Struct(node):
    return toSEFL(node.fields)

def Type_Table(node):
    return toSEFL(node.table)

def Type_Typedef(node):
    return "<Type_Typedef>" + str(node.Node_ID)

def Type_Unknown(node):
    return "<Type_Unknown>" + str(node.Node_ID)

def Type_Error(node):
    return "<Type_Error>" + str(node.Node_ID)

def Type_Extern(node):
    return "<Type_Extern>" + str(node.Node_ID)

def Declaration_MatchKind(node):
    return "<Declaration_MatchKind>" + str(node.Node_ID)

def Type_Header(node):
    headerName = node.name
    fields = []
    for field in node.fields.vec:
        fields.append(field)
    headerTuple = (headerName, fields)
    headers.append(headerTuple)
    return ""

def P4Parser(node):
    returnString = declareParameters(node)
    returnString += toSEFL(node.parserLocals)
    returnString += toSEFL(node.states)
    return returnString 

def Type_Enum(node):
    return "<Type_Enum>" + str(node.Node_ID)

def Type_Parser(node):
    return "<Type_Parser>" + str(node.Node_ID)

def ParserState(node):
    components = ""
    for v in node.components.vec:
        components = components + "\t" + toSEFL(v) + ",\n"
    expression = ""
    if hasattr(node, 'selectExpression'):
        expression = toSEFL(node.selectExpression)
    parser = "val " + node.name + " = InstructionBlock(\n" + components + "\t" + expression + "\n)\n\n"
    return parser


    returnString = "val parserState_" + node.name + " = InstructionBlock(\n" + toSEFL(node.components) + ")\n"
    return returnString

########### HELPER FUNCTIONS ###########

def declareParameters(node):
    returnString = ""
    for param in node.type.applyParams.parameters.vec:
        if param.direction == "out" and param.type.Node_Type == 'Type_Name':
            for header in headers:
                if header[0] == param.type.path.name:
                    returnString += "Allocate('validityBit_" + param.name + "'),\n"
                    returnString += "Assign('validityBit_" + param.name + "', ConstantValue(0)),\n"
                    for field in header[1]:
                        returnString += allocateHeader(field, "_" + param.name) + ",\n"
    return returnString + "\n"

def ifStatement(node):
    condition = ""
    if node.condition.Node_Type == 'PathExpression':
        condition = formatATNode(node.condition) + ", :==:(ConstantValue(1))"
    elif node.condition.Node_Type == 'LNot' and node.condition.expr.Node_Type == 'PathExpression':
        condition = formatATNode(node.condition.expr) + ", :==:(ConstantValue(0))"
    else:
        condition = str(toSEFL(node.condition))
    returnString = "If(Constrain(" + condition + "), " + str(toSEFL(node.ifTrue))
    if hasattr(node, "ifFalse"):
        returnString += ", " + str(toSEFL(node.ifFalse))
    returnString += ")"
    return returnString

def greater(node):
    return str(toSEFL(node.left)) + " > " + str(toSEFL(node.right))

def add(node):
    return ":+:(" + formatATNode(node.left) + ", " + formatATNode(node.right) + ")"

def sub(node):
    return ":-:(" + formatATNode(node.left) + ", " + formatATNode(node.right) + ")"

def allocateHeader(node, appendName):
    returnString = ""
    global currentPacketAllocationPosition
    returnString += "CreateTag('" + node.name + appendName +  "', " + str(currentPacketAllocationPosition) + "),\n"
    if node.type.Node_Type == 'Type_Bits':
        currentPacketAllocationPosition += node.type.size
        returnString += "Allocate(Tag('" + node.name + appendName +  "'), " + str(node.type.size) + ")"
    elif node.type.Node_Type == 'Type_Boolean':
        currentPacketAllocationPosition += 1
        returnString += "Allocate(Tag('" + node.name + appendName + "'), 1)" #assuming boolean size is 1 bit
    elif node.type.Node_Type == 'Type_Name':
        pass
    elif node.type.Node_Type == 'Type_Stack':
        returnString += "// " + str(node.type.elementType.path.name) + "[" + str(node.type.size.value) + "] " + str(node.name)
    else:
        raise ValueError('Allocating unknown node type: ' + node.type.Node_Type)
    return returnString

def allocate(node):
    return "Allocate('" + node.name + "')"

def assign(node):
    if node.right.Node_Type == "Equ":
        returnString = "If(Constrain('" + str(toSEFL(node.right.left)) + "', :==:(" + str(toSEFL(node.right.right))  + ")), " + \
                       "Assign('" + str(toSEFL(node.left)) + "', ConstantValue(1)), Assign('" + str(toSEFL(node.left)) + "', ConstantValue(0)))"
    else:
        returnString = "Assign('" + str(toSEFL(node.left)) + "', " + formatATNode(node.right) + ")"
    return returnString

def formatATNode(node): # :@
    value = ""
    if node.Node_Type == 'PathExpression' or node.Node_Type == 'Member' :
        value = ":@('" + str(toSEFL(node)) + "')"
    elif isExternal(node):
        value = "SymbolicValue()"
    else:
        value = str(toSEFL(node))
    return value

def isExternal(node):
    # the variable could be external or inside an external variable
    return "//Extern" in toSEFL(node)

def getHeaderType(headerName):
    return structFieldsHeaderTypes[headerName]