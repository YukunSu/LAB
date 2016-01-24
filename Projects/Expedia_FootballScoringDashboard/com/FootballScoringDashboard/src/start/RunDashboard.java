package start;

import java.util.Scanner;

import display.Display;

/**
 * Main method
 * @author YK
 *
 */
public class RunDashboard {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Display.printWelcomeMessage();
        Display.printHelpMessage();
        GameFlow.DashboardFlow(input);
        Display.printQuitMessage();
        input.close();
    }

}
