/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissorsstep2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // initialize variables
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        int userChoice;
        int cpuRandom;
        int numberOfRounds = 0;
        int maxRounds = 10;
        String strRounds = "!";
       
        System.out.println("How many rounds would you like to play? Please input a number between 1 - 10:");
        // numberOfRounds = sc.nextInt();
        strRounds = sc.nextLine();
        numberOfRounds = Integer.parseInt(strRounds);
       
        if (numberOfRounds < 10 && numberOfRounds > 0) {
            // Computer asks user for his choice
            System.out.println("Please enter: rock = " + rock + " or paper = " + paper + " or scissors = " + scissors);
            userChoice = sc.nextInt();

            // Computer randomly chooses between Rock (1), Paper (2), or Scissors (3)
            Random rGen = new Random();
            cpuRandom = rGen.nextInt(3) + 1;
            System.out.println("The computer choice is " + cpuRandom);

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
            System.out.println("The computer choose " + choice);

            // Result is tie, user win, or cpu win
            if (cpuRandom == userChoice) {
                System.out.println("The Result is a Tie!");
            }

            if (cpuRandom == paper) {
                if (userChoice == rock) {
                    System.out.println("Paper Wraps Rock - Computer Wins!");

                } else if (userChoice == scissors) {
                    System.out.println("Scissors cuts Paper - User Wins!");
                }

                if (cpuRandom == rock) {
                    if (userChoice == paper) {
                        System.out.println("Paper wraps Rock - User Wins!");
                    }
                }

            } else if (userChoice == scissors) {
                System.out.println("Rock breaks Scissors - CPU Wins!");
            }

            if (cpuRandom == scissors) {
                if (userChoice == rock) {
                    System.out.println("Rock breaks Scissors - User Wins!");

                } else if (userChoice == paper) {
                    System.out.println("Scissors cuts Paper - Computer Wins!");
                }
            }
        } else {
            System.out.println("This is not a valid number - Program now terminates");
        }

    }
}
