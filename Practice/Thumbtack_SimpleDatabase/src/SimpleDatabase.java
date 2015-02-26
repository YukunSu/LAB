package src;

import java.util.Scanner;
import java.util.Stack;

/**
 * In this simple database example, I use stack to represent database. It consists different tables
 * or in other words, maps. I created an object, which is called Command, to represent tables or
 * maps. Each Command object contains two maps. One is the variable names and their corres-
 * ponding value. Another one is the values and the amount of variables that are set to this value.
 * Transaction commands decide which Command object should the program points to, which
 * means which tables or maps the user executes their commands on. Using the push and pop
 * methods, the table can be switched from one to the other easily. The content of each table is
 * changed by executing the data commands. Detailed information of each command is listed below.
 * 
 * Data Commands:
 * SET name value 每 Set the variable name to the value value. Neither variable names nor values
 *                                will contain spaces.
 * GET name 每 Print out the value of the variable name, or NULL if that variable is not set.
 * UNSET name 每 Unset the variable name, making it just like that variable was never set.
 * NUMEQUALTO value 每 Print out the number of variables that are currently set to value. If no
 *                                        variables equal that value, print 0.
 * END 每 Exit the program. Your program will always receive this as its last command.
 * 
 * Transaction Commands
 * BEGIN 每 Open a new transaction block. Transaction blocks can be nested; a BEGIN can be
 *                issued inside of an existing block.
 * ROLLBACK 每 Undo all of the commands issued in the most recent transaction block, and close
 *                        the block. Print nothing if successful, or print NO TRANSACTION if no transaction
 *                        is in progress.
 * COMMIT 每 Close all open transaction blocks, permanently applying the changes made in them.
 *                    Print nothing if successful, or print NO TRANSACTION if no transaction is in progress.
 * @author Yukun
 *
 */
public class SimpleDatabase {
    public static void main(String[] args) {
        /* Create a scanner to get user input */
        Scanner input = new Scanner(System.in);

        /* Create a Command object to let user execute their commands */
        Command cmd = new Command();

        /* Create a stack to store the transaction blocks */
        Stack<Command> commandStack = new Stack<Command>();

        /*
         * Push the first Command Object on the stack so that the user can start
         * input commands
         */
        commandStack.push(cmd);

        /* Get first user input command */
        String command = input.nextLine();

        /* Cotinue looping until user inputs "END" */
        while (!command.equals("END") && !command.isEmpty()) {
            /* Detect if user gives available commands with correct format */
            if (ExecuteCommands.isAppropriateCommand(command)) {
                commandStack = ExecuteCommands.runTransactionCommands(commandStack);
                if (!commandStack.isEmpty()) {
                    ExecuteCommands.runDataCommands(commandStack.peek());
                }
            } else {
                /* Print commands information when input is wrong */
                ExecuteCommands.runHelp();
            }

            /* Get next user input */
            command = input.nextLine();
        }

        /* Close the scanner */
        input.close();
    }

}

