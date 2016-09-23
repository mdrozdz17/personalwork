/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
class SimpleCalculator {

    public void run() {
        int num1;
        int num2;
        String operation;
        String q = null;

        Scanner sc = new Scanner(System.in);
        do {
        System.out.println("Please enter operation");
        System.out.println("You can choose + or - or / or  * or type q for quit ");
        operation = sc.next();

        System.out.println("Please enter your first operand");
        num1 = sc.nextInt();

        System.out.println("Please enter your second operand");
        num2 = sc.nextInt();

        switch (operation) {
            case "+":
                System.out.println("your answer is " + (num1 + num2));
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
        } while (operation.equals(q));
         System.out.println("Please enter operation");
        System.out.println("You can choose + or - or / or  * or type q for quit ");
       
    }
}
