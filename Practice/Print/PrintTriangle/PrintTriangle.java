package PrintTriangle;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintTriangle {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> arguments = new ArrayList<String>();
        boolean stop = false;
        while(!stop){
            String s = reader.nextLine();
            if(s.charAt(0) != '@'){
                arguments.add(s);
            } else {
                stop = true;
                reader.close();
            }
        }

        for (int i = 0; i < arguments.size(); i++) {
            printTriangle(arguments.get(i), i%2);
            //print empty line between triangles except for last line
            if(i != arguments.size() - 1) {
                System.out.println();
            }
        }
    }

    private static void printTriangle(String input, int hollow) {
        //hollow = 0 print solid triangle
        //hollow = 1 print hollow triangle
        String inputArray[] = input.split("\\s");
        char s = inputArray[0].charAt(0);
        int height = 0;
        int length = 0;
        try {
            height = Integer.parseInt(inputArray[1]);
            length = height*2 - 1;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    if(hollow == 0) {
                        if (j < length/2 - i || j > length/2 + i) {
                            System.out.print(" ");
                        } else {
                            System.out.print(s);
                        }
                    } else {
                        if (j != length/2 - i && j != length/2 + i && i != height - 1) {
                            System.out.print(" ");
                        } else {
                            System.out.print(s);
                        }
                    }
                }
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input should contain one character, one space and one digit.");
        }
    }
}
