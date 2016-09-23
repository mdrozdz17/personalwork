/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.consoleio;

import java.util.Scanner;

/**
 *
 *
 * /**
 *
 * @author apprentice
 */
public class ConsoleIO {

    // 1. Display a prompt to the user and read in an integer. The prompt value should be passed
    //    in as a parameter and the value that is read in should be the return value of the method.
    public int getInteger(String prompt) {

        Scanner sc = new Scanner(System.in);
        String x;
        int i = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(prompt);
                x = sc.nextLine();
                i = Integer.parseInt(x);

                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer");
                System.out.println();
            }
        }
        return i;

    }

    // 2.  Display a prompt to the user and read in an integer between max value and min value.
    //     The prompt value, min, and max should be passed in as parameters. The value read in
    //     from the console should be the return value of the method. This method must keep
    //     asking the user for input until the value is in range
    public int getIntInRange(String prompt, int max, int min) {

        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        String x;
        int i = 0;

        while (!valid) {
            try {
                System.out.println(prompt);
                x = sc.nextLine();

                i = Integer.parseInt(x);

                if (i > max) {
                    System.out.println("Please enter a value less than " + max);
                } else if (i < min) {
                    System.out.println("Please enter a value more than " + min);
                } else {
                    valid = true;

                }

            } catch (NumberFormatException ex) {

                System.out.println("Please enter an integer");
                System.out.println();

            }

        }
        return i;
    }

    // 3. Display a prompt to the user and read in a string. The prompt value should be passed in
    //    as a parameter and the value that is read in should be the return value of the method.
    public String getString(String prompt) {

        Scanner sc = new Scanner(System.in);

        System.out.println(prompt);
        String x = sc.nextLine();

        return x;

    }

    // 4. Display a prompt to the user and read in a float. The prompt value should be passed in
    //    as a parameter and the value that is read in should be the return value of the method
    public float getFloat(String prompt) {

        Scanner sc = new Scanner(System.in);
        float i = 0;
        String x;
        boolean valid = false;

        do {

            try {
                System.out.println(prompt);
                x = sc.nextLine();

                i = Float.parseFloat(x);

                valid = true;

            } catch (NumberFormatException ex) {

                System.out.println("Please enter a valid float");
                System.out.println();
            }

            return i;

        } while (!valid);
    }

    // 5. Display a prompt to the user and read in a float between max value and min value. The
    //    prompt value, min, and max should be passed in as parameters. The value read in from
    //    the console should be the return value of the method. This method must keep asking
    //   the user for input until the value is in range.
    public float getFloatInRange(String prompt, int max, int min) {

        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        String x;
        float i = 0;

        while (!valid) {

            try {
                System.out.println(prompt);
                x = sc.nextLine();

                i = Float.parseFloat(x);

                if (i > max) {
                    System.out.println("Please enter a value less than " + max);
                } else if (i < min) {
                    System.out.println("Please enter a value more than " + min);
                } else {
                    valid = true;

                }
            } catch (NumberFormatException ex) {

                System.out.println("Please enter a float");
                System.out.println();
            }
        }
        return i;
    }

    // 6. Display a prompt to the user and read in a double. The prompt value should be passed
    //    in as a parameter and the value that is read in should be the return value of the method.
    public double getDouble(String prompt) {

        Scanner sc = new Scanner(System.in);
        double i = 0;
        String x;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(prompt);
                x = sc.nextLine();

                i = Double.parseDouble(x);

                valid = true;

            } catch (NumberFormatException ex) {

                System.out.println("Please enter a valid double");
                System.out.println();
            }
        }
        return i;

    }

    // 7. Display a prompt to the user and read in a double between max value and min value.
    //    The prompt value, min, and max should be passed in as parameters. The value read in
    //    from the console should be the return value of the method. This method must keep
    //     asking the user for input until the value is in range
    public double getDoubleInRange(String prompt, int max, int min) {

        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        String x;
        double i = 0;

        while (!valid) {
            try {
                System.out.println(prompt);
                x = sc.nextLine();

                i = Double.parseDouble(x);

                if (i > max) {
                    System.out.println("Please enter a value less than " + max);
                } else if (i < min) {
                    System.out.println("Please enter a value more than " + min);
                } else {
                    valid = true;
                    

                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a double");
                System.out.println();
            }
        }
        return i;
    }

    // 8. Print a given string to the console. The prompt value should be passed in as a
    //    parameter
    public void printString(String prompt) {

        System.out.println(prompt);
    }

}
