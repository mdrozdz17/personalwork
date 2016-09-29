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
public class RockPaperScissors {
    private int wins;
    private int losses;
    private int ties;
    private ConsoleIO console = new ConsoleIO();

    
    public void playGame(){
        //MAX_GAMES shows that you can have static properties
        // Properties and methods can be static
        console.showMessage("You can play up to : " + RPSUtilities.MAX_GAMES + " games");
        int userChoice = getUserChoice();
        console.showMessage("the user chose: " + userChoice);
        outputResults();
    }
    
    private int getUserChoice(){
        return console.promptForIntWithRange(
                "Make a choice:\n. Rock\n2. Paper\n3. Scissors",1,3);
    }
    
    private String calculateResult(int computerChoice, int userChoice){
        if (computerChoice > userChoice) {
           losses++;
        return "computer";
    } else if (userChoice > computerChoice) {
        wins++;
            return "user";
            }
        ties++;
        return "tie";
    }
    
      private void outputResults() {
         console.showMessage("Wins: " + wins);
         console.showMessage("Losses: " + losses);
         console.showMessage("Ties: " + ties);
    }
    
}
