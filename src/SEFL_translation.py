
blocks = []
headers = []
structFieldsHeaderTypes = {} #structField, structFieldType
structs = {} # structName, listOfFields
headerStackSize = {}
currentPacketAllocationPosition = 0
emitPosition = 0
typedef = {} #typedefName, typedefNode
actionIDs = {} #actionName, nodeID
tableIDs = {} #tableName, nodeID
declarationTypes = {} #instanceName, instanceType
processedBlocks = set() #blockId set
package = ""

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
            #returnString += "<<" + str(v.Node_ID) + ">>"
            nodeString = toSEFL(v)
            if nodeString != "":
                returnString += nodeString + "\n"
        return returnString
    else:
        return globals()[node.Node_Type](node) #calls corresponding type function according to node type

########### TYPE FUNCTIONS ###########

def P4Program(node):
    return toSEFL(node.declarations)

def P4Control(node):
    returnString = "//Control\n"
    returnString += "lazy val " + node.name + " = InstructionBlock(\n\t"
    actions = ""
    tables = ""
    for local in node.controlLocals.vec:
        if local.Node_Type == "Declaration_Variable" or local.Node_Type == "Declaration_Instance":
            nodeString = toSEFL(local)
            if nodeString != "":
                returnString += nodeString + ",\n\t"
        elif local.Node_Type == "P4Action":
            actions += toSEFL(local) + "\n"
        elif local.Node_Type == "P4Table":
            tables += toSEFL(local) + "\n"
    #returnString += toSEFL(node.type.applyParams)
    for v in node.body.components.vec:
        returnString += toSEFL(v) + ",\n\t"
    if len(node.body.components.vec) > 0:
        returnString = returnString[:-3]
    returnString += "\n)\n\n"
    returnString += actions
    returnString += tables
    return returnString

def BlockStatement(node):
    #blockName = "block" + str(node.Node_ID)
    #if node.Node_ID not in processedBlocks:
    #    processedBlocks.add(node.Node_ID)
    #    components = ""
    #    for v in node.components.vec:
    #        nodeString = toSEFL(v)
    #        if nodeString != "":
    #            components = components + "\t" + nodeString + ",\n"
    #    components = components[:-2]
    #    block = "lazy val " + blockName + " = InstructionBlock(\n" + components + "\n)\n\n"
    #    blocks.append(block)
    #return blockName

    returnString = "\n\t\tInstructionBlock(\n"
    for v in node.components.vec:
        nodeString = toSEFL(v)
        if nodeString != "":
            returnString += "\t\t\t" + nodeString + ",\n"
    returnString = returnString[:-2]
    returnString += "\n\t\t)"
    if len(node.components.vec) > 0:
        return returnString
    else:
        return ""

def BAnd(node):
    return "<BOr>" + str(node.Node_ID)

def BOr(node):
    return "<BOr>" + str(node.Node_ID)

def BXor(node):
    return "<BXor>" + str(node.Node_ID)

def Cast(node):
    return "<Cast>" + str(node.Node_ID)

def Geq(node):
    return "<Geq>" + str(node.Node_ID)

def Leq(node):
    return "<Leq>" + str(node.Node_ID)

def LAnd(node):
    return "<LAnd>" + str(node.Node_ID)

def LOr(node):
    return "<LOr>" + str(node.Node_ID)

def Slice(node):
    return "<Slice>" + str(node.Node_ID)

def Shl(node):
    #return "<Shl>" + str(node.Node_ID)
    return "SymbolicValue()" #TODO: proper model this operation

def Shr(node):
    #return "<Shr>" + str(node.Node_ID)
    return "SymbolicValue()" #TODO: proper model this operation

def Mul(node):
    returnString = ""
    if node.left.Node_Type == "Constant":
        returnString = mul_constant(node.left.value, node.right)
    elif node.right.Node_Type == "Constant":
        returnString = mul_constant(node.right.value, node.left)
    else:
        returnString = "<Mul>" + str(node.Node_ID)
    return returnString

def ActionList(node):
    #assuming every action will be forked
    returnString = "\tFork("
    for action in node.actionList.vec:
        if action.expression.Node_Type == "PathExpression":
            returnString += action.expression.path.name + "_" + str(actionIDs[action.expression.path.name]) + ", "
        elif action.expression.Node_Type == "MethodCallExpression":
            returnString += action.expression.method.path.name + "_" + str(actionIDs[action.expression.method.path.name]) + ", "
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
    if node.value == True:
        return "ConstantValue(1)"
    else:
        return "ConstantValue(0)"

def Constant(node):
    if node.type.Node_Type == "Type_Bits":
        return "ConstantBitVector(" + str(node.value) + ", " + str(node.type.size) + ")"
    else:
        return "ConstantValue(" + str(node.value) + ")"

def ConstructorCallExpression(node):
    return "<ConstructorCallExpression>" + str(node.Node_ID) 

def Declaration_Instance(node):
    returnString = ""
    if node.name == "main":
        if package == "V1Switch":
            parser = node.arguments.vec[0].type.path.name if hasattr(node.arguments.vec[0].type, "path") else node.arguments.vec[0].type.name
            ingress = node.arguments.vec[2].type.path.name if hasattr(node.arguments.vec[2].type, "path") else node.arguments.vec[2].type.name
            egress = node.arguments.vec[3].type.path.name if hasattr(node.arguments.vec[3].type, "path") else node.arguments.vec[3].type.name
            deparser = node.arguments.vec[5].type.path.name if hasattr(node.arguments.vec[5].type, "path") else node.arguments.vec[5].type.name
            returnString += "lazy val main = InstructionBlock(" +  parser + ", Allocate(\"action_run\"), " + ingress + ", " + egress + ", " + deparser +  ")\n"
        elif package == "VSS":
            parser = node.arguments.vec[0].type.path.name if hasattr(node.arguments.vec[0].type, "path") else node.arguments.vec[0].type.name
            ingress = node.arguments.vec[1].type.path.name if hasattr(node.arguments.vec[1].type, "path") else node.arguments.vec[1].type.name
            deparser = node.arguments.vec[2].type.path.name if hasattr(node.arguments.vec[2].type, "path") else node.arguments.vec[2].type.name
            returnString += "lazy val main = InstructionBlock(" +  parser + ", Allocate(\"action_run\"), " + ingress + ", " + deparser +  ")\n"
    elif hasattr(node.type, "path"):
        declarationTypes[node.name] = node.type.path.name
    return returnString        
    
def Declaration_Variable(node):
    if  node.type.Node_Type == 'Type_Name':
        returnString = ""
        for header in headers:
            if header[0] == node.type.path.name:
                returnString += "Allocate('validityBit_" + node.name + "\"),\n"
                returnString += "Assign('validityBit_" + node.name + "\", ConstantValue(0)),\n"
                for field in header[1]:
                    returnString += "Allocate(\"" + field.name + "_" + node.name + "\"),"
        return returnString
    return allocate(node)

def EmptyStatement(node):
    return "<EmptyStatement>" + str(node.Node_ID)

def Neq(node):
    return "\"" + toSEFL(node.left) +  "\", :~:(:==:(" + toSEFL(node.right) + "))"

def Equ(node):
    return "\"" + toSEFL(node.left) +  "\", :==:(" + toSEFL(node.right) + ")"

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
        nodeName = toSEFL(node.expr)
        if nodeName in tableIDs.keys():
            return nodeName + "_" + str(tableIDs[nodeName])
        elif nodeName in declarationTypes.keys():
            return declarationTypes[nodeName]
        else:
            return nodeName

def Method(node):
    if node.name == "mark_to_drop": #V1 specific
        return mark_to_drop()
    else:
        return toSEFL(node.type)

def MethodCallExpression(node):
    returnString = ""
    # extract method
    if hasattr(node.method, 'member') and node.method.member == "extract":
        returnString += extract(node)
    # emit method
    elif hasattr(node.method, 'member') and node.method.member == "emit":
        returnString += emit(node)
     # execute meter, TODO: separate this into an 'extern methods' method
    elif hasattr(node.method, 'member') and node.method.member == "execute_meter":
        returnString += "Assign(\"" + toSEFL(node.arguments.vec[1]) + "\", SymbolicValue())"
    # read register, TODO: separate this into an 'extern methods' method
    elif hasattr(node.method, 'member') and node.method.member == "read":
        returnString += "Assign(\"" + toSEFL(node.arguments.vec[0]) + "\", SymbolicValue())"
    # write register, TODO: separate this into an 'extern methods' method
    elif hasattr(node.method, 'member') and node.method.member == "write":
        #ignore it
        pass
    # clone3, TODO: separate this into an 'extern methods' method
    elif hasattr(node.method, 'path') and node.method.path.name == "clone3":
         #ignore it
        pass
    # count, TODO: separate this into an 'extern methods' method
    elif hasattr(node.method, 'member') and node.method.member == "count":
         #ignore it
        pass
    # count, TODO: separate this into an 'extern methods' method
    elif hasattr(node.method, 'path') and node.method.path.name == "hash":
         returnString += "Assign(\"" + toSEFL(node.arguments.vec[0]) + "\", SymbolicValue())"
    # extern method: Name it as extern for later processing
    elif hasattr(node.method, 'expr') and node.method.expr.type.Node_Type == "Type_Extern":
        returnString +=  "//Extern: " + toSEFL(node.method)
    #verify method
    elif hasattr(node.method, 'path') and node.method.path.name == "verify":
        returnString += "If(Constrain(\"" + node.arguments.vec[0].path.name + "\", :==:(ConstantValue(0))), Fail(\"" + node.arguments.vec[1].member + "\"))"
     #SetValid method
    elif hasattr(node.method, 'member') and node.method.member == "setValid":
        returnString += "Assign(\"" + toSEFL(node.method.expr) + ".isValid\", ConstantValue(1))"
     #SetInvalid method
    elif hasattr(node.method, 'member') and node.method.member == "setInvalid":
        returnString += "Assign(\"" + toSEFL(node.method.expr) + ".isValid\", ConstantValue(0))"
    else:
        returnString = toSEFL(node.method)
    return returnString

def MethodCallStatement(node):
    return toSEFL(node.methodCall)

def NameMapProperty(node):
    return "<NameMapProperty>" + str(node.Node_ID)

def P4Action(node):
    actionIDs[node.name] = node.Node_ID
    actionData = "Assign(\"action_run\", ConstantValue(" + str(node.Node_ID) + ")), \n\t"
    for param in node.parameters.parameters.vec:
        if param.direction == "":
            actionData +=  "Assign(\"" + param.name + "\", SymbolicBitVector(" + str(paramSize(param)) + ")),\n\t"
    body = toSEFL(node.body)
    if body == "":
        actionData = actionData[:-4]    
    return "// Action\nlazy val " + node.name + "_" + str(node.Node_ID) + " = InstructionBlock(\n\t" + actionData + body + "\n)\n\n"

def P4Table(node):
    tableIDs[node.name] = node.Node_ID
    return "//Table\nlazy val " + node.name + "_" + str(node.Node_ID) + " = InstructionBlock(\n" + toSEFL(node.properties) + ")\n\n"

def ParameterList(node):
    returnString = ""
    for parameter in node.parameters.vec:
        returnString += allocate(parameter) + ",\n\t"
    return returnString

def Path(node):
    return node.name

def PathExpression(node):
    return toSEFL(node.path)

def Property(node):
    if node.name == "default_action":
        return "\t// default_action " + toSEFL(node.value)
    elif node.name == "size":
        return "\t// size " + toSEFL(node.value)
    elif node.name == "actions":
        return toSEFL(node.value)
    else:
        return ""

def SelectExpression(node):
    expressions = node.select.components.vec
    exp = []
    for expression in expressions:
        if expression.Node_Type == 'Slice':
            #TODO: slice bit string currently not supported #bitop
            return ""
        if expression.Node_Type == 'Member':
            exp.append(toSEFL(expression.expr) + "." + expression.member)
        if  expression.Node_Type == "MethodCallStatement":
            if expression.method.member == "isValid":
                exp.append("validityBit_" + expression.method.expr.path.name)

    cases = node.selectCases.vec
    returnString = ""
    multipleMatches = (cases[0].keyset.Node_Type == "ListExpression")
    if multipleMatches:
        returnString += selectMultiple(node, cases, exp)
    else:
        returnString += selectSingle(node, cases, exp)
    return returnString

def selectSingle(node, cases, exp):
    returnString = ""
    atLeastOneIf = False
    for case in cases:
        if case.keyset.Node_Type == 'Mask':
            #todo: fix mask #bitop
            returnString = "//TODO: MASK\n"
        elif case.keyset.Node_Type == 'DefaultExpression':
            returnString += case.state.path.name
        elif case.keyset.Node_Type == 'Constant':
            atLeastOneIf = True
            returnString += "If(Constrain(\"" + str(exp[0]) + "\", :==:(ConstantBitVector(" + str(case.keyset.value) + ", " + str(paramSize(case.keyset)) + "))), " + case.state.path.name + ",\n\t"
    #close with ) according to cases length
    if len(cases) == 1 and atLeastOneIf:
        returnString = returnString[:-3] + ")"
    else:
        for i in range(0, len(cases) - 1):
            returnString += ")"
    return returnString

def selectMultiple(node, cases, exp):
    #not the best solution. Multiple branches can occur. AND statement would be better.
    returnString = "Allocate(\"selectedMultipleParam\"),\n\t"
    returnString += "Assign(\"selectedMultipleParam\", ConstantValue(0)),\n\t"
    for case in cases:
        if case.keyset.Node_Type == 'Mask':
            #todo: fix mask #bitop
            returnString = "//TODO: MASK\n"
        elif case.keyset.Node_Type == 'DefaultExpression':
            returnString += "If(Constrain(\"selectedMultipleParam\", :==:(ConstantValue(0))),\n\t\t"
            returnString += "InstructionBlock(Assign(\"selectedMultipleParam\", ConstantValue(1)), " + case.state.path.name + ")),\n\t"
        elif case.keyset.Node_Type == "ListExpression":
            returnString += "If(Constrain(\"selectedMultipleParam\", :==:(ConstantValue(0))), \n\t\t"
            for idx,e in enumerate(exp):
                if case.keyset.components.vec[idx].Node_Type == "Mask":
                    returnString += "//TODO: MASK\n"
                else:
                    returnString += "If(Constrain(\"" + str(e) + "\", :==:(ConstantValue(" + str(case.keyset.components.vec[idx].value) + "))), \n\t\t"
            returnString += "InstructionBlock(Assign(\"selectedMultipleParam\", ConstantValue(1)), " + case.state.path.name + "))"
            for idx,e in enumerate(exp):
                returnString += ")"
            returnString += ",\n\t"
    returnString += "Deallocate(\"selectedMultipleParam\")"
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
    elif  node.type.Node_Type == "Type_Stack":
        structFieldsHeaderTypes[node.name] = node.type.elementType.path.name
        headerStackSize[node.name] = node.type.size.value
    return returnString

def SwitchCase(node):
    return toSEFL(node.statement)

def SwitchStatement(node):
    returnString = ""
    if node.expression.member == "action_run":
        returnString += toSEFL(node.expression.expr) + ", \n\t"
        defaultCase = None
        openIf = 0
        for case in node.cases.vec:
            if case.label.Node_Type != "DefaultExpression":
                returnString += "If(Constrain(\"action_run\", :==:(" + str(actionIDs[toSEFL(case.label)]) + ")), " + toSEFL(case) + ", "
                openIf += 1
            else:
                defaultCase = case
        if defaultCase:
            returnString += toSEFL(case)
        else:
            returnString = returnString[:-2]
        for i in range(0, openIf):
            returnString += ")"


    else:
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
    #return "<Type_Control>" + str(node.Node_ID)
    return ""

def Type_Method(node):
    #return "<Type_Method>" + str(node.Node_ID)
    return ""

def Type_Name(node):
    return "<Type_Name>" + str(node.Node_ID)

def TypeNameExpression(node):
    return ""

def Type_Package(node):
    global package
    package = node.name
    return ""

def Type_Struct(node):
    structs[node.name] = node.fields.vec 
    return toSEFL(node.fields)

def Type_Table(node):
    return toSEFL(node.table)

def Type_Typedef(node):
    typedef[node.name] = node
    return ""
    
def Type_Unknown(node):
    return "<Type_Unknown>" + str(node.Node_ID)

def Type_Error(node):
    #return "<Type_Error>" + str(node.Node_ID)
    return ""

def Type_Extern(node):
    return ""

def Declaration_MatchKind(node):
    #return "<Declaration_MatchKind>" + str(node.Node_ID)
    return ""

def Type_Header(node):
    headerName = node.name
    fields = []
    for field in node.fields.vec:
        fields.append(field)
    headerTuple = (headerName, fields)
    headers.append(headerTuple)
    return ""

def P4Parser(node):
    returnString = toSEFL(node.states)
    returnString += "lazy val " + node.name + " = InstructionBlock(\n\t"
    for l in node.parserLocals.vec:
        parseLocal = toSEFL(l)
        if parseLocal != "":
            returnString += toSEFL(l) + ",\n\t"
    returnString += declareParameters(node)
    returnString += "\tstart\n)\n"
    return returnString 

def Type_Enum(node):
    #return "<Type_Enum>" + str(node.Node_ID)
    return ""

def Type_Parser(node):
    #return "<Type_Parser>" + str(node.Node_ID)
    return ""

def ParserState(node):
    components = ""
    for v in node.components.vec:
        components = components + "\t" + toSEFL(v) + ",\n"
    expression = ""
    if hasattr(node, 'selectExpression'):
        expression = toSEFL(node.selectExpression)
    if node.name == "reject":
        expression += "Fail(\"Packet dropped\")"
    parser = "lazy val " + node.name + " = InstructionBlock(\n" + components + "\t" + expression + "\n)\n\n"
    return parser


    returnString = "lazy val parserState_" + node.name + " = InstructionBlock(\n" + toSEFL(node.components) + ")\n"
    return returnString

########### HELPER FUNCTIONS ###########

def paramSize(param):
    size = typedef[param.type.path.name].type.size if param.type.Node_Type == "Type_Name" else param.type.size
    return size

def declareParameters(node):
    returnString = ""
    for param in node.type.applyParams.parameters.vec:
        if (param.direction == "out" or param.direction == "inout") and param.type.Node_Type == 'Parameter':
            returnString += declareParameter(param.type)
        if (param.direction == "out" or param.direction == "inout") and param.type.Node_Type == 'Type_Name':
            returnString += declareParameter(param)
    return returnString + "\n"

def declareParameter(param):
    returnString = "\n\t//Allocate " + param.name + "\n"
    for h in structs[param.type.path.name]:
        if h.name in structFieldsHeaderTypes:
            if h.name in headerStackSize:
                returnString += "\tAllocate(\"" + h.name + "Index\"),\n"
                returnString += "\tAssign(\"" + h.name + "Index\", ConstantValue(0)),\n"
                for i in range(0, headerStackSize[h.name]):
                    returnString += allocateHeader(param, h, i)
            else:
                returnString += allocateHeader(param, h)
        else: # struct field is not a header
            returnString += "\tAllocate(\"" + param.name + "." + h.name + "\"),\n"
            #returnString += "\tAssign(\"" + param.name + "." + h.name + "\", SymbolicBitVector(" + str(paramSize(param)) + ")),\n"
    return returnString

def allocateHeader(param, h, stackIndex = -1):
    returnString = ""
    index = ""
    if stackIndex != -1:
        index = "_" + str(stackIndex)
    for header in headers:
        if header[0] == getHeaderType(h.name):
            returnString += "\tAllocate(\"" + param.name + "." + h.name + index + ".isValid\"),\n"
            returnString += "\tAssign(\"" + param.name + "." + h.name + index + ".isValid\", ConstantValue(0)),\n"
            for field in header[1]:
                returnString += "\tAllocate(\"" + param.name + "." + h.name + index +  "." + field.name + "\"),\n"
    if getHeaderType(h.name) in structs:
        for field in structs[getHeaderType(h.name)]:
            returnString += "\tAllocate(\"" + param.name + "." + h.name + index + "." + field.name + "\"),\n"
    return returnString

def ifStatement(node):
    condition = ""
    returnString = ""
    if node.condition.Node_Type == 'LAnd' or node.condition.Node_Type == 'LOr':
        returnString += logicalExpression(node.condition)
        booleanStatement = node.condition.Node_Type + str(node.condition.Node_ID)
        returnString += "If(Constrain(\"" + booleanStatement + "\"), :==:(ConstantValue(1)), " + str(toSEFL(node.ifTrue))
        if hasattr(node, "ifFalse"):
            returnString += ", " + str(toSEFL(node.ifFalse))
        returnString += "),\n\t"
        returnString += "Deallocate(\"" + booleanStatement + "\")"
    else:
        if node.condition.Node_Type == 'PathExpression':
            condition = "\"" + str(toSEFL(node.condition)) + "\", :==:(ConstantValue(1))"
        elif node.condition.Node_Type == 'LNot' and node.condition.expr.Node_Type == 'PathExpression':
            condition = "\"" + str(toSEFL(node.condition.expr)) + "\", :==:(ConstantValue(0))"
            condition = "\"" + str(toSEFL(node.condition.expr)) + "\", :==:(ConstantValue(0))"
        elif node.condition.Node_Type == 'MethodCallExpression' and node.condition.method.member == 'isValid':
             condition = "\""+ str(toSEFL(node.condition)) + "\", :==:(ConstantValue(1))"
        else:
            condition = str(toSEFL(node.condition))
        returnString = "If(Constrain(" + condition + "), " + str(toSEFL(node.ifTrue))
        if hasattr(node, "ifFalse"):
            returnString += ", " + str(toSEFL(node.ifFalse))
        returnString += ")"
    return returnString

def logicalExpression(node):
    booleanStatement = node.Node_Type + str(node.Node_ID)
    returnString = "Allocate(\"" + booleanStatement + "\"),\n\t"
    leftIsLogicalExpression = node.left.Node_Type == 'LAnd' or node.left.Node_Type == 'LOr'
    rightIsLogicalExpression = node.right.Node_Type == 'LAnd' or node.right.Node_Type == 'LOr'
    if leftIsLogicalExpression:
        returnString += logicalExpression(node.left)
        lExp = "\"" + node.left.Node_Type + str(node.left.Node_ID) + "\""
    else:
        lExp = toSEFL(node.left)
    if rightIsLogicalExpression:
        returnString += logicalExpression(node.right)
        rExp = "\"" + node.right.Node_Type + str(node.right.Node_ID) + "\""
    else:
        rExp = toSEFL(node.right)
    if node.Node_Type == 'LAnd':
        returnString += "If(Constrain(" + lExp + "),\n\t\t"
        returnString += "If(Constrain(" + rExp + "),\n\t\t\t"
        returnString += "Assign(\"" +  booleanStatement + "\", ConstantValue(1)),\n\t\t"
        returnString += "Assign(\"" + booleanStatement + "\", ConstantValue(0))),\n\t"
        returnString += "Assign(\"" + booleanStatement + "\", ConstantValue(0))),\n\t"
    elif node.Node_Type == 'LOr':
        returnString += "If(Constrain(" + lExp + "),\n\t\t"
        returnString += "If(Constrain(" + rExp + "),\n\t\t\t"
        returnString += "Assign(\"" +  booleanStatement + "\", ConstantValue(1)),\n\t\t"
        returnString += "Assign(\"" + booleanStatement+ "\", ConstantValue(0))),\n\t"
        returnString += "Assign(\"" + booleanStatement + "\", ConstantValue(1))),\n\t"
    if leftIsLogicalExpression:
        returnString += "Deallocate(" + lExp + "),\n\t"
    if rightIsLogicalExpression:
        returnString += "Deallocate(" + rExp + "),\n\t"
    return returnString

def greater(node):
    return str(toSEFL(node.left)) + " > " + str(toSEFL(node.right))

def add(node):
    return ":+:(" + formatATNode(node.left) + ", " + formatATNode(node.right) + ")"

def sub(node):
    return ":-:(" + formatATNode(node.left) + ", " + formatATNode(node.right) + ")"

def allocate(node):
    return "Allocate(\"" + node.name + "\")"

def assign(node):
    if node.right.Node_Type == "Equ":
        returnString = "If(Constrain(\"" + str(toSEFL(node.right.left)) + "\", :==:(" + formatATNode(node.right.right)  + ")), " + \
                       "Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(1)), Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(0)))"
    elif node.right.Node_Type == "Geq":
        returnString = "If(Constrain(\"" + str(toSEFL(node.right.left)) + "\", :>=:(" + formatATNode(node.right.right)  + ")), " + \
                       "Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(1)), Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(0)))"
    elif node.right.Node_Type == "Leq":
        returnString = "If(Constrain(\"" + str(toSEFL(node.right.left)) + "\", :<=:(" + formatATNode(node.right.right)  + ")), " + \
                       "Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(1)), Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(0)))"
    elif node.right.Node_Type == "Grt":
        returnString = "If(Constrain(\"" + str(toSEFL(node.right.left)) + "\", :>:(" + formatATNode(node.right.right)  + ")), " + \
                       "Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(1)), Assign(\"" + str(toSEFL(node.left)) + "\", ConstantValue(0)))"
    else:
        returnString = "Assign(\"" + str(toSEFL(node.left)) + "\", " + formatATNode(node.right) + ")"
    return returnString

def formatATNode(node): # :@
    value = ""
    if node.Node_Type == 'PathExpression' or node.Node_Type == 'Member' or  node.Node_Type =='ArrayIndex':
        value = ":@(\"" + str(toSEFL(node)) + "\")"
    elif node.Node_Type == 'Cast':
        value = formatATNode(node.expr)
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

def emit(node):
    returnString = ""
    hdrName = toSEFL(node.arguments.vec[0])
    returnString += "//Emit " + hdrName + "\n\t"
    headerName = ""
    if node.arguments.vec[0].Node_Type == "ArrayIndex":
        headerName = node.arguments.vec[0].left.member
    else:
        headerName = hdrName.split(".")[1]
    for header in headers:
        if header[0] == getHeaderType(headerName):
            for field in header[1]:
                returnString += "CreateTag(\"" + hdrName + "." + field.name + "\", " + str(emitPosition) + "),\n\t"
                size = paramSize(field)
                returnString += "Allocate(Tag(\"" + hdrName + "." + field.name + "\"), " + str(size) + "),\n\t"
                returnString += "Assign(Tag(\"" + hdrName + "." + field.name + "\"), :@(\"" + hdrName + "." + field.name + "\")),\n\t"
                global emitPosition
                emitPosition += size
    return returnString[:-3]

def extract(node):
    headerToExtract = toSEFL(node.arguments.vec[0])
    returnString = "//Extract " + headerToExtract + "\n"
    for header in headers:
        # header stack position
        if node.arguments.vec[0].Node_Type == "ArrayIndex":
            if header[0] == getHeaderType(node.arguments.vec[0].left.member):
                headerToExtract = node.arguments.vec[0].left.expr.path.name
                returnString += "\tAssign(\"" + headerToExtract + ".isValid\", ConstantValue(1)),\n"
                for field in header[1]:
                    returnString += "\tAssign(\"" + headerToExtract + "." + "_" + str(node.arguments.vec[0].right.value) + field.name + "\", SymbolicValue()),\n"
        # next header stack element
        elif node.arguments.vec[0].member == "next":
            if header[0] == getHeaderType(node.arguments.vec[0].expr.member):
                hdr = headerToExtract.split(".")[1] #remove next keyword
                for i in range(0, headerStackSize[hdr]):
                    returnString += "\tIf(Constrain(\"" + hdr + "Index\", :==:(ConstantValue(" + str(i) + "))),\n\t\tInstructionBlock(\n"
                    returnString += "\t\t\tAssign(\"" + hdr +  "_" + str(i) + ".isValid" + "\", ConstantValue(1)),\n"
                    for field in header[1]:
                        returnString += "\t\t\tAssign(\"" + hdr + "_" + str(i) + "." + field.name + "\", SymbolicValue()),\n"
                    returnString = returnString[:-2]
                    returnString += "),\n"  
                returnString = returnString[:-2] 
                for i in range(0, headerStackSize[hdr]):
                    returnString += ")"
                returnString += ",\n\tAssign(\"" + hdr + "Index\", :+:(:@(\"" + hdr + "Index\"), ConstantValue(1))),\n"
        #regular header field
        elif header[0] == getHeaderType(node.arguments.vec[0].member):
            returnString += "\tAssign(\"" + headerToExtract + ".isValid\", ConstantValue(1)),\n"
            for field in header[1]:
                returnString += "\tAssign(\"" + headerToExtract + "." + field.name + "\", SymbolicBitVector(" + str(paramSize(field)) + ")),\n"
    return returnString[:-2]


def mul_constant(const, node):
    returnString = ""
    value = formatATNode(node)
    for i in range(const):
        if i == const - 1:
            returnString += ":+:(" +value + ", " + value +  ")"
        else:
            returnString += ":+:(" + value + ", "
    for i in range(const - 1):
        returnString += ")"
    return returnString

# ---- V1 specific ----

def mark_to_drop():
    return "lazy val mark_to_drop = Fail(\"Packet dropped\")\n"