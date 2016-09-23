/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.refactorrps;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RefactorRps {
    
    public void run() {

        do {
            // method for asking the user how many rounds to play and playing game
            askUserForChoice();
        } while (again == 1);
        // method to show Overall Winner
        overallWinner();
    } 
    public static int numberOfRounds, rock = 1, paper = 2, scissors = 3, userChoice;
    public static int cpuRandom, again, yes = 1, no = 2, tie, cpuWins, userWins;
    public static Scanner sc = new Scanner(System.in);
    public static Random rGen = new Random();
    

    public static void askUserForChoice() {
        System.out.println("How many rounds would you like to play? Please input a number between 1 - 10:");
        numberOfRounds = sc.nextInt();

        if (numberOfRounds <= 10 && numberOfRounds > 0) {

            // Use the for loop to play number of rounds the user wants.
            for (int r = 0; r < numberOfRounds; r++) {

                // Computer asks user for his choice
                System.out.println("Please enter: rock = " + rock + " or paper = " + paper + " or scissors = " + scissors);
                userChoice = sc.nextInt();

                // Computer randomly chooses between Rock (1), Paper (2), or Scissors (3)
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
                // Output the results of the game from the rounds the user selected
                System.out.println("The number of Ties were:  " + tie + "\n" + "The number of Computer Wins were: " + cpuWins + "\n" + "The number of User Wins were: " + userWins + "\n");

            }
            System.out.println("\n" + "Do you want to play again?" + " yes = " + yes + " or " + " no = " + no);
            again = sc.nextInt();

            // Use the for loop to play number of rounds the user wants.
            // Part of if-then-else statment, commented on line 35 to show that if
            // numberOfRounds does not equal "if" statment to terminate and print out
            // the message below.
        } else {
            System.out.println("This is not a valid number - Program now terminates");
        }
    }
    public static void overallWinner() {
         if (cpuWins > userWins) {
            System.out.println("The overall Winner is the Computer!");
        } else if (userWins > cpuWins) {
            System.out.println("You are the Winner!");
         if (userWins == cpuWins) {
            System.out.println("The result is a Tie!");
        }
        if (again != 2) {
        } else {
            System.out.println("Thanks for playing!");
        }
}
    
}

    }

