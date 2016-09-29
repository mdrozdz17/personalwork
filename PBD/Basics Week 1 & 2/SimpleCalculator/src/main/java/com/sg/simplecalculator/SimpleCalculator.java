/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
class SimpleCalculator {

    // Making reference to ConsoleIO
    // Calling my ConsoleIO calculator in this instance
    ConsoleIO calculator = new ConsoleIO();

    public void run() {
        int num1;
        int num2;
        String oper1 = "+";
        String oper2 = "-";
        String oper3 = "*";
        String oper4 = "-";

        String operation;
        String q = "quit";
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Simple Calculator");
        do { // do while loop to run through calculator until user is read to quit
            System.out.println("Please enter operation");
            System.out.println("You can choose + or - or / or  * or type " + 0 + " for quit ");
            operation = sc.next();
            int quit = 0;
            // if UserInput = 0 quit the calculator
            if (operation.equals("0")) {
                System.out.println("Thanks for using Simple Calculator");
                System.exit(0);
            }
            // if statement saying if UserInput does not equal +, -, /, or * to prompt them to enter valid input
            if (!operation.equals(oper1) && !operation.equals(oper2) && !operation.equals(oper3) && !operation.equals(oper4)) {
                System.out.println("That is not a valid option. Please enter a valid option");

            } else {

                num1 = calculator.getInteger("Please enter your first operand");
                num2 = calculator.getInteger("Please enter your second operand");
            }
            switch (operation) {
                case "+":
                    System.out.println("your answer is " + doAddition());
                    break;
                case "-":
                    System.out.println("your answer is " + (num1 - num2));
                    break;
                case "/":
                    System.out.println("your answer is " + (num1 / num2));
                    break;
                case "*":
                    System.out.println("your answer is " + (num1 * num2));
                    break;
                default:
                    System.out.println("Wrong selection");
                    break;

            }

        } while (!operation.equals(0));

    }
}
