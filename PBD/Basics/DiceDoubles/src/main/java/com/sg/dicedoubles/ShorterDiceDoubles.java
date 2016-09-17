/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dicedoubles;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class ShorterDiceDoubles {
        @SuppressWarnings("empty-statement")
        public static void main(String[] args) {
        
     int die1;
     int die2;
     int diceTotal;
     
        System.out.println("HERE COMES THE DICE!");
        do {
        Random rGen = new Random();
        die1 = rGen.nextInt(6) + 1;
        die2 = rGen.nextInt(6) + 1;
        diceTotal = (die1 + die2);
        System.out.println("Roll #1: " + die1);
        System.out.println("Roll #2: " + die2);
        System.out.println("The total is " + diceTotal + "\n");
        
        } while (die1 != die2);
          
    }
    
}


