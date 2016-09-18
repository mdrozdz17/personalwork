/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blackjack;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class Blackjack {
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        int playerCard1; // declare Player Card 1
        int playerCard2; // declare card2
        int playerCard3;
        int playerCard4;
        int dealerCard1;
        int dealerCard2;
        int dealerCard3;
        int hit = 1;
        int stay = 2;
        int userChoice;
        
       
        
        System.out.println("Welcome to Matt's Blackjack program!");
      
            Random rGen = new Random();
            playerCard1 = rGen.nextInt(10) + 1;
            playerCard2 = rGen.nextInt(10) + 1;
            playerCard3 = rGen.nextInt(10) + 1;
            playerCard4 = rGen.nextInt(10) + 1;
            dealerCard1 = rGen.nextInt(10) + 1;
            dealerCard2 = rGen.nextInt(10) + 1;
            dealerCard3 = rGen.nextInt(10) + 1;
            
          System.out.println("You got a " + playerCard1 + " and a " + playerCard2);
    
          System.out.println("Your total is " + (playerCard1 + playerCard2));
          
          System.out.println("The dealer has a " + dealerCard1 + " showing");
          System.out.println("His total is hidden, too.");
          
          System.out.println("Would you like to hit = " + hit + " or stay = " + stay);
          userChoice = sc.nextInt();
          
          while (userChoice == 1) {
            System.out.println("You drew a " + playerCard3);
            int userCardTotal = (playerCard3 + playerCard2 + playerCard1);
            System.out.println("Your total is " +   userCardTotal);
            if (userCardTotal > 21) {
                System.out.println("Sorry you are over 21! Play Again!");
                break;
            }
            System.out.println("Would you like to hit = " + hit + " or stay = " + stay);
            userChoice = sc.nextInt(); }
          if (userChoice == 2) {
              System.out.println("Okay, dealers turn.");
              System.out.println("Dealer's hidden card was a " + dealerCard2);
              System.out.println("Dealer's total was " + (dealerCard1 + dealerCard2));
              System.out.println("Dealer's total is " + (dealerCard2 + dealerCard1)); }
              
            if (16 >= dealerCard1 + dealerCard2 ) {
              System.out.println("The dealer chooses to Hit " + hit);
              int dealerCardTotal = (dealerCard3 + dealerCard2 + dealerCard1);
              System.out.println("The dealer's total is " + dealerCardTotal);
             } else {
              System.out.println("Dealer Stays");
                      }
            
              System.out.println("Dealer total is " + (dealerCard3 + dealerCard2 + dealerCard1));
              int dealerCardTotal = dealerCard3 + dealerCard2 + dealerCard1;           
              System.out.println("Your total is " + (playerCard3 + playerCard2 + playerCard1));
              int playerCardTotal = playerCard3 + playerCard2 + playerCard1;           
              
              if (playerCardTotal >= 22) {
                  System.out.println("You went over 21, You Lose!");
              
              if (dealerCardTotal >= 22) {   
                  System.out.println("You went over 21, You Lose!");
              }
              System.exit(0);
              }
                  
              if (playerCardTotal > dealerCardTotal) {
                  System.out.println("YOU WIN!");
              }else{
                  System.out.println("DEALER WINS!");
              }
             
              



}
}