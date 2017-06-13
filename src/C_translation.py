
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

def run(node):
    returnString = ""
    program = toC(node)
    returnString += program 
    return returnString
    

def toC(node):
    #print str(node.Node_ID) + ": " + node.Node_Type
    if 'Vector' in node.Node_Type:
        returnString = ""
        for v in node.vec:
            #returnString += "<<" + str(v.Node_ID) + ">>"
            nodeString = toC(v)
            if nodeString != "":
                returnString += nodeString + "\n"
        return returnString
    else:
        return globals()[node.Node_Type](node) #calls corresponding type function according to node type

########### TYPE FUNCTIONS ###########

def P4Program(node):
    return toC(node.declarations)

def P4Control(node):
    returnString = "//Control\n"
    returnString += "void " + node.name + "() {\n\t"
    actions = ""
    tables = ""
    for local in node.controlLocals.vec:
        if local.Node_Type == "Declaration_Variable" or local.Node_Type == "Declaration_Instance":
            nodeString = toC(local)
            if nodeString != "":
                returnString += nodeString + "\n\t"
        elif local.Node_Type == "P4Action":
            actions += toC(local) + "\n"
        elif local.Node_Type == "P4Table":
            tables += toC(local) + "\n"
    for v in node.body.components.vec:
        returnString += toC(v) + "\n\t"
    if len(node.body.components.vec) > 0:
        returnString = returnString[:-2]
    returnString += "\n}\n\n"
    returnString += actions
    returnString += tables
    return returnString

def BlockStatement(node):
    returnString = ""
    for v in node.components.vec:
        nodeString = toC(v)
        if nodeString != "":
            returnString += "\t" + nodeString + "\n"
    return returnString

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
    return str(toC(node.left)) + " * " + str(toC(node.right))

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
    return toC(node.left) + "_" + str(node.right.value)

def AssignmentStatement(node):
    return assign(node)

def BoolLiteral(node):
    if node.value == "true":
        return "1"
    else:
        return "0"

def Constant(node):
    return str(node.value)

def ConstructorCallExpression(node):
    return "<ConstructorCallExpression>" + str(node.Node_ID) 

def Declaration_Instance(node):
    returnString = ""
    if node.name == "main":
        parser = node.arguments.vec[0].type.path.name if hasattr(node.arguments.vec[0].type, "path") else node.arguments.vec[0].type.name
        ingress = node.arguments.vec[2].type.path.name if hasattr(node.arguments.vec[2].type, "path") else node.arguments.vec[2].type.name
        egress = node.arguments.vec[3].type.path.name if hasattr(node.arguments.vec[3].type, "path") else node.arguments.vec[3].type.name
        deparser = node.arguments.vec[5].type.path.name if hasattr(node.arguments.vec[5].type, "path") else node.arguments.vec[5].type.name
        returnString += "int main() {\n\t" +  parser + "();\n\tint action_run;\n\t" + ingress + "();\n\t" + egress + "();\n\t" + deparser +  "();\n\treturn 0;\n}\n"
    elif hasattr(node.type, "path"):
        declarationTypes[node.name] = node.type.path.name
    return returnString        
    
def Declaration_Variable(node):
    if  node.type.Node_Type == 'Type_Name':
        returnString = ""
        for header in headers:
            if header[0] == node.type.path.name:
                returnString += "Allocate('validityBit_" + node.name + "\"),\n"
                returnString += "validityBit_" + node.name + "= 0;\n"
                for field in header[1]:
                    returnString += "Allocate(\"" + field.name + "_" + node.name + "\"),"
        return returnString
    return allocate(node)

def EmptyStatement(node):
    return "<EmptyStatement>" + str(node.Node_ID)

def Neq(node):
    return "(" + toC(node.left) +  " != " + toC(node.right) + ")"

def Equ(node):
    return "(" + toC(node.left) +  " == " + toC(node.right) + ")"

def ExpressionValue(node):
    return toC(node.expression) 

def Grt(node):
    return greater(node)

def IfStatement(node):
    return ifStatement(node)

def Key(node):
    returnString = "\t// keys: "
    for key in node.keyElements.vec:
            returnString += toC(key.expression) + ", "
    return returnString[:-2]

def LNot(node):
    return "!" + toC(node.expr)

def Member(node):
    if node.member != 'apply':
        return toC(node.expr) + "." + node.member
    else:
        nodeName = toC(node.expr)
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
        return toC(node.type)

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
        returnString += toC(node.arguments.vec[1]) + " = SymbolicValue();"
    # read register, TODO: separate this into an 'extern methods' method
    elif hasattr(node.method, 'member') and node.method.member == "read":
        returnString += toC(node.arguments.vec[0]) + " = SymbolicValue();"
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
         returnString += toC(node.arguments.vec[0]) + " = SymbolicValue();"
    # extern method: Name it as extern for later processing
    elif hasattr(node.method, 'expr') and node.method.expr.type.Node_Type == "Type_Extern":
        returnString +=  "//Extern: " + toC(node.method)
    #verify method
    elif hasattr(node.method, 'path') and node.method.path.name == "verify":
        returnString += "If(Constrain(\"" + node.arguments.vec[0].path.name + "\", :==:(ConstantValue(0))), Fail(\"" + node.arguments.vec[1].member + "\")"
     #SetValid method
    elif hasattr(node.method, 'member') and node.method.member == "setValid":
        returnString += toC(node.method.expr) + ".isValid = 1;"
     #SetInvalid method
    elif hasattr(node.method, 'member') and node.method.member == "setInvalid":
        returnString += toC(node.method.expr) + ".isValid = 0;"
    else:
        returnString = toC(node.method) + "();"
    return returnString

def MethodCallStatement(node):
    return toC(node.methodCall)

def NameMapProperty(node):
    return "<NameMapProperty>" + str(node.Node_ID)

def P4Action(node):
    actionIDs[node.name] = node.Node_ID
    actionData = "action_run = " + str(node.Node_ID) + ";\n\t"
    for param in node.parameters.parameters.vec:
        if param.direction == "":
            actionData += param.name + " = SymbolicValue();\n\t"
    return "// Action\nvoid " + node.name + "_" + str(node.Node_ID) + "() {\n\t" + actionData + toC(node.body) + "\n}\n\n"

def P4Table(node):
    tableIDs[node.name] = node.Node_ID
    return "//Table\nvoid " + node.name + "_" + str(node.Node_ID) + "() {\n" + toC(node.properties) + "}\n\n"

def ParameterList(node):
    returnString = ""
    for parameter in node.parameters.vec:
        returnString += allocate(parameter) + ",\n\t"
    return returnString

def Path(node):
    return node.name

def PathExpression(node):
    return toC(node.path)

def Property(node):
    if node.name == "default_action":
        return "\t// default_action " + toC(node.value)
    elif node.name == "size":
        return "\t// size " + toC(node.value)
    elif node.name == "actions":
        return toC(node.value)
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
            exp.append(toC(expression.expr) + "." + expression.member)
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
    returnString = "switch(" + str(exp[0]) + "){\n"
    for case in cases:
        if case.keyset.Node_Type == 'Mask':
            #todo: fix mask #bitop
            returnString = "//TODO: MASK\n"
        elif case.keyset.Node_Type == 'DefaultExpression':
            returnString += "\t\tdefault:\t" + case.state.path.name + "(); break;\n"
        elif case.keyset.Node_Type == 'Constant':
            returnString += "\t\tcase " + str(case.keyset.value) + ":\t" + case.state.path.name + "(); break;\n"
    returnString += "\t}"
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
    return toC(node.statement)

def SwitchStatement(node):
    returnString = ""
    if node.expression.member == "action_run":
        returnString += toC(node.expression.expr) + ", \n\t"
        defaultCase = None
        openIf = 0
        for case in node.cases.vec:
            if case.label.Node_Type != "DefaultExpression":
                returnString += "If(Constrain(\"action_run\", :==:(" + str(actionIDs[toC(case.label)]) + ")), " + toC(case) + ", "
                openIf += 1
            else:
                defaultCase = case
        if defaultCase:
            returnString += toC(case)
        else:
            returnString = returnString[:-2]
        for i in range(0, openIf):
            returnString += ")"


    else:
        switchCases = toC(node.cases).replace("\n", ",")
        returnString = "Fork(InstructionBlock(), " + switchCases[:-1] + ")"
    return returnString

def TableProperties(node):
    return toC(node.properties)

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
    structs[node.name] = node.fields.vec 
    return toC(node.fields)

def Type_Table(node):
    return toC(node.table)

def Type_Typedef(node):
    typedef[node.name] = node
    return ""
    
def Type_Unknown(node):
    return "<Type_Unknown>" + str(node.Node_ID)

def Type_Error(node):
    return "<Type_Error>" + str(node.Node_ID)

def Type_Extern(node):
    return ""

def Declaration_MatchKind(node):
    return "<Declaration_MatchKind>" + str(node.Node_ID)

def Type_Header(node):
    #not sure if it remains
    fields = []
    for field in node.fields.vec:
        fields.append(field)
    headerTuple = (node.name, fields)
    headers.append(headerTuple)
    ####
    returnString = "struct " + node.name + "{\n"
    for field in node.fields.vec:
        returnString += "\t" + field.name + ";\n"
    returnString += "}\n"
    return returnString

def P4Parser(node):
    returnString = toC(node.states)
    returnString += "void  " + node.name + "() {\n\t"
    for l in node.parserLocals.vec:
        returnString += toC(l) + "\n\t"
    returnString += declareParameters(node)
    returnString += "\tstart();\n}\n"
    return returnString 

def Type_Enum(node):
    return "<Type_Enum>" + str(node.Node_ID)

def Type_Parser(node):
    return "<Type_Parser>" + str(node.Node_ID)

def ParserState(node):
    components = ""
    for v in node.components.vec:
        components = components + "\t" + toC(v) + ",\n"
    expression = ""
    if hasattr(node, 'selectExpression'):
        expression = toC(node.selectExpression)
    if node.name == "reject":
        expression += "printf(\"Packet dropped\");\n\texit(0);"
    parser = "void " + node.name + "() {\n" + components + "\t" + expression + "\n}\n\n"
    return parser


    returnString = "val parserState_" + node.name + " = InstructionBlock(\n" + toC(node.components) + ")\n"
    return returnString

########### HELPER FUNCTIONS ###########

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
                returnString += "\t" + h.name + "Index = 0;\n"
                for i in range(0, headerStackSize[h.name]):
                    returnString += allocateHeader(param, h, i)
            else:
                returnString += allocateHeader(param, h)
        else: # struct field is not a header
            returnString += "\tAllocate(\"" + param.name + "." + h.name + "\"),\n"
            returnString += "\t" + param.name + "." + h.name + " = SymbolicValue();\n"
    return returnString

def allocateHeader(param, h, stackIndex = -1):
    returnString = ""
    index = ""
    if stackIndex != -1:
        index = "_" + str(stackIndex)
    for header in headers:
        if header[0] == getHeaderType(h.name):
            returnString += "\tAllocate(\"" + param.name + "." + h.name + index + ".isValid\"),\n"
            returnString += "\t" + param.name + "." + h.name + index + ".isValid = 0;\n"
            for field in header[1]:
                returnString += "\tAllocate(\"" + param.name + "." + h.name + index +  "." + field.name + "\"),\n"
    if getHeaderType(h.name) in structs:
        for field in structs[getHeaderType(h.name)]:
            returnString += "\tAllocate(\"" + param.name + "." + h.name + index + "." + field.name + "\"),\n"
    return returnString

def ifStatement(node):
    condition = ""
    returnString = ""
    condition = str(toC(node.condition))
    returnString = "if(" + condition + ") {\n\t" + str(toC(node.ifTrue)) + "\n}"
    if hasattr(node, "ifFalse"):
        returnString += " else {\n\t" + str(toC(node.ifFalse)) + "\n}"
    return returnString


def greater(node):
    return str(toC(node.left)) + " > " + str(toC(node.right))

def add(node):
    return formatATNode(node.left) + " + " + formatATNode(node.right)

def sub(node):
    return formatATNode(node.left) + " - " + formatATNode(node.right)

def allocate(node):
    return "Allocate(\"" + node.name + "\")"

def assign(node):
    return str(toC(node.left)) + " = " + str(toC(node.right))

def formatATNode(node): # :@
    value = ""
    if node.Node_Type == 'Cast':
        value = formatATNode(node.expr)
    elif isExternal(node):
        value = "SymbolicValue()"
    else:
        value = str(toC(node))
    return value

def isExternal(node):
    # the variable could be external or inside an external variable
    return "//Extern" in toC(node)

def getHeaderType(headerName):
    return structFieldsHeaderTypes[headerName]

def emit(node):
    returnString = ""
    hdrName = toC(node.arguments.vec[0])
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
                size = typedef[field.type.path.name].type.size if field.type.Node_Type == "Type_Name" else field.type.size
                returnString += "Allocate(Tag(\"" + hdrName + "." + field.name + "\"), " + str(size) + "),\n\t"
                returnString += "Assign(Tag(\"" + hdrName + "." + field.name + "\"), :@(\"" + hdrName + "." + field.name + "\")),\n\t"
                global emitPosition
                emitPosition += size
    return returnString[:-3]

def extract(node):
    headerToExtract = toC(node.arguments.vec[0])
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
                returnString += "\tAssign(\"" + headerToExtract + "." + field.name + "\", SymbolicValue()),\n"
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
    return "void mark_to_drop() {\n\tprintf(\"Packet dropped\\n\");\n\texit(0);\n}\n"