/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    //create a scanner for all methods to use

    private static Scanner sc = new Scanner(System.in);

    //prompt user and read in a string
    public static String promptString(String prompt) {
        String userInput;
        while (true) {
            showMessageln(prompt);
            try {
                userInput = sc.nextLine();
                return userInput;
            } catch (Exception e) {
                showMessageln("Unexpected input error.");
            }
        }
    }

    //prompt user and read in an integer
    //input String prompt
    //output integer
    public static int promptInt(String prompt) {
        return promptIntRange(prompt, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    //another call signature to prevent looking up the command for positive infinity.
    public static int promptIntPositive(String prompt) {
        return promptIntRange(prompt, 0, Float.POSITIVE_INFINITY);
    }

    //prompt user and read in an integer between max and min
    public static int promptIntRange(String prompt, float min, float max) {
        int userInput;
        while (true) {
            //display a prompt asking the user for input
            showMessageln(prompt);
            try {
                //read the input, and try to parse it into an integer
                //parseInt throws a NumberFormatException
                userInput = Integer.parseInt(sc.nextLine());
                if (userInput >= min && userInput <= max) {
                    //user followed instructions, return the input.
                    return userInput;
                } else {
                    //integer input, not in range
                    showMessageln("Input outside valid range.");
                }
            } catch (NumberFormatException e) {
                //failed to enter an integer
                showMessageln("Invalid input.");
            }
        }
    }

    //prompt user and read in a float
    public static float promptFloat(String prompt) {
        return promptFloatRange(prompt, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    //prompt user and read in a float between max and min
    //more detailed comments in the IntegerRange method.
    public static Float promptFloatRange(String prompt, float min, float max) {
        float userInput;
        while (true) {
            showMessageln(prompt);
            try {
                userInput = Float.parseFloat(sc.nextLine());
                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    showMessageln("Input outside valid range.");
                }
            } catch (NumberFormatException e) {
                showMessageln("Invalid input.");
            }
        }
    }

    //prompt user and read in a double
    public static double promptDouble(String prompt) {
        return promptDoubleRange(prompt, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    //prompt user and read in a double between max and min
    //more detailed comments in the IntegerRange method.
    public static double promptDoubleRange(String prompt, float min, float max) {
        double userInput;
        while (true) {
            showMessageln(prompt);
            try {
                userInput = Double.parseDouble(sc.nextLine());
                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    showMessageln("Input outside valid range.");
                }
            } catch (NumberFormatException e) {
                showMessageln("Invalid input.");
            }
        }
    }

    //print a given string to the console.
    //input String message
    //output void
    public static void showMessage(String message) {
        System.out.print(message);
    }

    public static void showMessageln(Object message) {
        System.out.println(message);

    }
}
