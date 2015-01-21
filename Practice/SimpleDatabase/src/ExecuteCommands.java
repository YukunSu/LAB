package src;

import java.util.Stack;

/**
 * This class is used to execute different types of commands,
 * detect whether it is a correct command or not and display
 * help information when needed.
 * @author Yukun
 *
 */
public class ExecuteCommands {

    private static String[] commands = null;

    /**
     * Detect whether it is a correct command or not.
     * @param command user input.
     * @return Return true if user gives correct command and format
     * false otherwise.
     */
    public static boolean isAppropriateCommand(String command) {
        boolean isCorrect = false;
        //Split the command string by empty characters and stores them
        //into an array.
        commands = command.split("\\s");

        //Detect transaction commands
        if (command.equals("BEGIN") || command.equals("ROLLBACK")
                || command.equals("COMMIT")) {
            isCorrect = true;
            commands[0] = command;
        } else {
            //If it is "SET" command, length should equal to three and the
            //last string element should be all digits; If it is "GET" or "UNSET"
            //command, length should equal to two; If it is "NUMEQUALTO"
            //command, length should equal to two and the last string element
            //should be all digits.
            if (commands[0].equals("SET") && commands.length == 3) {
                if (isNumeric(commands[2])) {
                    isCorrect = true;
                }
            } else if (commands[0].equals("GET") && commands.length == 2) {
                isCorrect = true;
            } else if (commands[0].equals("UNSET") && commands.length == 2) {
                isCorrect = true;
            } else if (commands[0].equals("NUMEQUALTO") && commands.length == 2) {
                if (isNumeric(commands[1])) {
                    isCorrect = true;
                }
            }
        }
        return isCorrect;
    }

    /**
     * Execute data commands
     * @param cmd A Command object which contains two maps
     */
    public static void runDataCommands(Command cmd) {
        if (commands[0].equals("GET")) {
            int result = cmd.getValue(commands[1]);
            if (result == -1) {
                System.out.println("NULL");
            } else {
                System.out.println(result);
            }
        } else if (commands[0].equals("SET")) {
            cmd.addKey(commands[1], Integer.parseInt(commands[2]));
        } else if (commands[0].equals("UNSET")) {
            cmd.removeKey(commands[1]);
        } else if (commands[0].equals("NUMEQUALTO")) {
            int result = cmd.getKeyQuantity(Integer.parseInt(commands[1]));
            System.out.println(result);
        }
    }

    /**
     * Execute transaction commands
     * @param commandStack A stack contains all maps
     * @return Return the command stack
     */
    public static Stack<Command> runTransactionCommands(
            Stack<Command> commandStack) {
        if (commands[0].equals("BEGIN")) {
            Command newCommand = new Command();
            if (!commandStack.isEmpty()) {
                Command previousCommand = commandStack.peek();
                // Pass the tables to the next transaction block
                newCommand.setMapStrToInt(previousCommand.getMapStrToInt());
                newCommand.setMapIntToInt(previousCommand.getMapIntToInt());
            }
            //Push new table to database
            commandStack.push(newCommand);
        } else if (commands[0].equals("ROLLBACK")) {
            if (isTransactionBlockExists(commandStack.size())) {
                //Delete table from database
                commandStack.pop();
            }
        } else if (commands[0].equals("COMMIT")) {
            if (isTransactionBlockExists(commandStack.size())) {
                //Save changes, clear all tables except the last one
                Command lastCommand = commandStack.pop();
                commandStack.clear();
                commandStack.push(lastCommand);
            }
        }
        return commandStack;
    }

    /**
     * Display help information
     */
    public static void runHelp() {
        System.out.println("Incorrect Command Entered!");
        System.out.println("The available commands are the following:");
        System.out
                .println("SET name value 每 Set the variable name to the value value. Neither variable names nor values will contain spaces.");
        System.out
                .println("GET name 每 Print out the value of the variable name, or NULL if that variable is not set.");
        System.out
                .println("UNSET name 每 Unset the variable name, making it just like that variable was never set.");
        System.out
                .println("NUMEQUALTO value 每 Print out the number of variables that are currently set to value. If no variables equal that value, print 0.");
        System.out
                .println("END 每 Exit the program. Your program will always receive this as its last command.");
        System.out
                .println("BEGIN 每 Open a new transaction block. Transaction blocks can be nested; a BEGIN can be issued inside of an existing block.");
        System.out
                .println("ROLLBACK 每 Undo all of the commands issued in the most recent transaction block, and close the block. Print nothing if successful, or print NO TRANSACTION if no transaction is in progress.");
        System.out
                .println("COMMIT 每 Close all open transaction blocks, permanently applying the changes made in them. Print nothing if successful, or print NO TRANSACTION if no transaction is in progress.");
    }

    private static boolean isTransactionBlockExists(int stackSize) {
        if (stackSize <= 1) {
            System.out.println("NO TRANSACTION");
            return false;
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}

