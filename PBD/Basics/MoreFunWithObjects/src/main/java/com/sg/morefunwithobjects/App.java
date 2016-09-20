/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.morefunwithobjects;

// Moving the Calculator to another package means we need to import it
// We import it by the name of the package + class name
import com.sg.morefunwithobjects.models.Calculator;

/**
 *
 * @author apprentice
 */
public class App {
    
    // only playGame needs to be public so that App can see it. All other 
    // can be private
    

    public static void main(String[] args) {
        RockPaperScissors rps = new RockPaperScissors();
        rps.playGame();
        
        // This is an example of static
        System.out.println(Calculator.add(32,20));
    }
    
    
}
