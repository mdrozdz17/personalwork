/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.morefunwithobjects;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    Scanner sc = new Scanner(System.in);
    
    // Prompt user for input
    // Input: promp (String)
    // Output: int
    public int promptForInt(String prompt){
        System.out.println(prompt);
        return sc.nextInt();
        
    }
    
    // Prompt a user for an integer within a range
    // Input: prompt (String), min (int), max (int)
    // Output: int
    public int promptForIntWithRange(String prompt, int min, int max){
        int myInt;
    // Using a do...while so that this code executes as least once
    // Stop prompting when the int is within range
    do {
        System.out.println(prompt);
        myInt = sc.nextInt();
        } while (myInt < min || myInt > max);
    return myInt;
    }
    // Display a message
    // Input: message (String)
    // Output: nothing (void)
    public void showMessage(String message){
        System.out.println(message);
    }
    
}
