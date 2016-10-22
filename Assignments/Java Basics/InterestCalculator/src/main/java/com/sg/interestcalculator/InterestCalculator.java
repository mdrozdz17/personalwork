/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;

import java.text.DecimalFormat;
import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class InterestCalculator {
   

    public static void main(String[] args) {
         DecimalFormat d = new DecimalFormat("'$'0.00");
        Scanner sc = new Scanner(System.in);
        double annualInterestRate = 10; // 10% annual interest rate
        double money; // $500 initial principal
        int numberOfYears = 20; // 20 years total for money to compound
        int quarterly = 4; // 10 / 4 = 2.5% interest
        double interestEarned = 0; // initialize variable to make it equal to money
        double newDollarAmount = 0;

        System.out.println("Please input the number of dollars you would like to calculate interest for over a 20 year period");
        money = sc.nextInt();
        
        
        for (int i = 1; i <= numberOfYears; i++) { // for loop to show 20 years of data

            System.out.println("The year is: " + i ); // Output the years 1-20
            
            // Shows John's starting Principal at the beginning of the year which was $500
            System.out.println("John's initial principal was " + d.format(money));
            interestEarned = money; // Make interestEarned (new variable) = to money
            
            for (int p = 1; p <= quarterly; p++) { // Use for loop to go through the loop 4 times
                // Assigns a new $ amount to the initial balance
                money = money * (1 + ((annualInterestRate / quarterly) / 100));
                
            }
            
              // Shows interest earned for the year (500 - interestEarned)
                System.out.println("The total amount of interest earned for the year was: " + d.format(money - interestEarned));
                // Shows the new dollar amount John will have each year with interest earned
                System.out.println("In 20 years John will have " + d.format(money));
                System.out.println("============================================");


        }

    }
}
