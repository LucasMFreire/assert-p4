import sys

def generate_commands_file(number_of_rules):

    with open("commands/commands_" + number_of_rules + ".txt", "a+") as f:
	command_string = ""
        for i in range(int(number_of_rules)):
            command_string += "table_add forward_table forward " + str(i) + " => 1\n"
            command_string += "table_add table_1 forward1 " + str(i) + " => 1\n"
	f.write(command_string[:-1])

generate_commands_file(sys.argv[1])
print "generated rules file in folder commands"
