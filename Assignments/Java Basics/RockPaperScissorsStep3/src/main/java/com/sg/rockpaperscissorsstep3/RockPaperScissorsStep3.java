/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissorsstep3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // initialize variables
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        int userChoice;
        int cpuRandom;
        int numberOfRounds = 0;
        String strRounds;

        // Adding three variables to keep track of ties, user wins and computer wins
        int tie = 0;
        int cpuWins = 0;
        int userWins = 0;
        
        // Ask user how many rounds they want to play
        System.out.println("How many rounds would you like to play? Please input a number between 1 - 10:");
        // numberOfRounds = sc.nextInt();
        strRounds = sc.nextLine();
        numberOfRounds = Integer.parseInt(strRounds);

        // if-then-else statment to only let program execute if numberOfRounds is less than 10
        // or is greater 0.
        if (numberOfRounds <= 10 && numberOfRounds > 0) {

            // Use the for loop to play number of rounds the user wants.
            for (int r = 0; r < numberOfRounds; r++) {

                // Computer asks user for his choice
                System.out.println("Please enter: rock = " + rock + " or paper = " + paper + " or scissors = " + scissors);
                userChoice = sc.nextInt();

                // Computer randomly chooses between Rock (1), Paper (2), or Scissors (3)
                Random rGen = new Random();
                cpuRandom = rGen.nextInt(3) + 1;
                System.out.println("The computer choice is " + cpuRandom);

                // Use Switch Statement for Computer's choice so that 1 = Rock, 2 = Paper
                // and 3 = Scissors
                String choice = "!";
                switch (cpuRandom) {
                    case 1:
                        choice = "Rock";
                        break;
                    case 2:
                        choice = "Paper";
                        break;
                    case 3:
                        choice = "Scissors";
                        break;
                }

                // Print out the Computer choice using the Switch Statement
                System.out.println("The computer choose " + choice);

                // Result is tie, user win, or cpu win
                if (cpuRandom == userChoice) {
                    System.out.println("The Result is a Tie!");
                    tie++;
                }

                if (cpuRandom == paper) {
                    if (userChoice == rock) {
                        System.out.println("Paper Wraps Rock - Computer Wins!");
                        cpuWins++;

                    } else if (userChoice == scissors) {
                        System.out.println("Scissors cuts Paper - User Wins!");
                        userWins++;
                    }

                    if (cpuRandom == rock) {
                        if (userChoice == paper) {
                            System.out.println("Paper wraps Rock - User Wins!");
                            userWins++;
                        }
                    }

                } else if (userChoice == scissors) {
                    System.out.println("Rock breaks Scissors - CPU Wins!");
                    cpuWins++;
                }

                if (cpuRandom == scissors) {
                    if (userChoice == rock) {
                        System.out.println("Rock breaks Scissors - User Wins!");
                        userWins++;

                    } else if (userChoice == paper) {
                        System.out.println("Scissors cuts Paper - Computer Wins!");
                        cpuWins++;
                    }
                }
                System.out.println("The number of Ties were:  " + tie + "\n" + "The number of Computer Wins were: " + cpuWins + "\n" + "The number of User Wins were: " + userWins + "\n");

            }
            // Use else if Statement to show who the Overall Winner is
            if (cpuWins > userWins) {
                System.out.println("The overall Winner is the Computer!");
            } else if (userWins > cpuWins) {
                System.out.println("You are the Winner!");
            } else {
                System.out.println("The result is a Tie!");
            }
            // Part of if-then-else statment, commented on line 35 to show that if
            // numberOfRounds does not equal "if" statment to terminate and print out
            // the message below.
        } else {
            System.out.println("This is not a valid number - Program now terminates");
        }
    }
}
