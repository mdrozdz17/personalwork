/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.windowmasterrefactored;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMasteRefactored {
    
  public static void main(String[] args) {
        
        // Take in user inputs for length and width
        String length = getUserInput("Please enter the length:");
        String width = getUserInput("Please enter the width:");
        
        // Change user inputs from strings to floats
        float floatLength = Float.parseFloat(length);
        float floatWidth = Float.parseFloat(width);
        
        float area = floatLength * floatWidth;
        float perimeter = (2*floatLength) + (2*floatWidth);
        
        // We use the f on our numbers to tell the compiler to treat them
        // as float values.
        float glassCost = area * 3.50f;
        float trimCost = 2.25f * perimeter;
        
        printWindowOrder(length, width, area, perimeter, glassCost, trimCost);
    }
    
    private static String getUserInput(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }
    
    private static void printOutput(String stuffToPrint){
        System.out.println("---------------");
        System.out.println(stuffToPrint);
    }
    
    // Changed length to length1 to show that the variable name in the
    // method parameter list does NOT have to match the variable name
    // of the value from where it's coming from
    private static void printWindowOrder(String length1, String width, 
                            float area, float perimeter, float glassCost,
                            float trimCost){
        printOutput("Window height = " + length1);
        printOutput("Window width = " + width);
        printOutput("Window area = " + area);
        printOutput("Window perimeter = " + perimeter);
        printOutput("Total Cost = " + (glassCost + trimCost));
    }
    
    
}
