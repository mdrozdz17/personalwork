/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
 // Calling ConsoleIO  with "io" as name of the instance. 
 ConsoleIO io = new ConsoleIO();
 // Calling SimpleCalculator2 from App.java and call the instance "calc"
 // This will be used to call the methods defined their.
 SimpleCalculator2 calc = new SimpleCalculator2();
 
        float num1 = 0;
        float num2 = 0;
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
            operation = sc.next(); // operation = UserInput
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
                // Using ConsoleIO.Java to call method getFloat
                num1 = io.getFloat("Please enter your first operand");
                num2 = io.getFloat("Please enter your second operand");
            }
            switch (operation) {
                case "+":
                    // Calling to Simplecalculator2.java with instance "calc" defined
                    // above to doAddition method in App.Java
                    System.out.println("your answer is " + calc.doAddition(num1,num2));
                    break;
                case "-":
                    // Calling to Simplecalculator2.java with instance "calc" defined
                    // above to doSubtraction method in App.Java
                    System.out.println("your answer is " + calc.doSubtration(num1,num2));
                    break;
                case "/":
                    // Calling to Simplecalculator2.java with instance "calc" defined
                    // above to doDivision method in App.Java
                    System.out.println("your answer is " + calc.doDivision(num1,num2));
                    break;
                case "*":
                    // Calling to Simplecalculator2.java with instance "calc" defined
                    // above to doMultiplication method in App.Java
                    System.out.println("your answer is " + calc.doMultiplication(num1, num2));
                    break;
                default:
                    System.out.println("Wrong selection");
                    break;
            }

        } while (!operation.equals(0));

    }
}
