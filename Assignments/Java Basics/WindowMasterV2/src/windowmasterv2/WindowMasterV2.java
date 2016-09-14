/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowmasterv2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMasterV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Take in user inputs for length and width 
        System.out.println("Please enter the length:");
        String length = sc.nextLine();         
        
        System.out.println("Please enter the width:");
        String width = sc.nextLine();
        
        // Prompts the user for the cost of the glass and cost of the trim
        
        System.out.println("Please enter the cost of the glass");
        String glassCost = sc.nextLine();
        
        System.out.println("Please enter the cost of the trim");
        String trimCost = sc.nextLine(); 
        
        // Change user input from strings to floats
        float floatLength = Float.parseFloat(length);
        float floatWidth = Float.parseFloat(width);
        float area = floatLength * floatWidth;
        float perimeter = (2*floatLength) + (2*floatWidth);
        float floatglassCost = Float.parseFloat(glassCost);
        float floattrimCost = Float.parseFloat(trimCost);
        
        // Shows total cost of trim and glass
        float totalCost = (floattrimCost * perimeter) + (floatglassCost * area);
        System.out.println("Window height = " + length);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + area);
        System.out.println("Window perimeter = " + perimeter);
        System.out.println("Glass Total = " + glassCost);
        System.out.println("Trim Total = " + trimCost);
        System.out.println("Cost Total = " + totalCost);
        
    }
    
    
}

