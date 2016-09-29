/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.morefunwithobjects;

/**
 *
 * @author apprentice
 */
//Created to show a possiblity for static methods
// Used when methods are associated with *a class*, not at the instance level
// See them as "helper methods", "utilities"
// Calculations, formatting... tehse are some common roles for static methods
public class RPSUtilities {
    public static final int MAX_GAMES = 10;
            
    public static String formatChoices(int choiceNum){
        String choice;
        switch (choiceNum){
            case 1:
                choice = "Rock";
                break;
            case 2:
                choice = "Paper";
                break;
            case 3:
                choice = "Scissors";
                break;
                default:
                choice = "invalid";
                break;
        }
                
              
    
}
}
