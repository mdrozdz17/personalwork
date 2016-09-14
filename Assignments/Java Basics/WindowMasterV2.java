/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowmaster;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Take in user inputs for length and width
        String length = sc.nextLine();
        String width;
        System.out.println("Please enter the length:");
        
        String width = sc.nextLine();
        System.out.println("Please enter the width:");
       
        
        // Change user input from strings to floats
        float floatLength = Float.parseFloat(length);
        float floatWidth = Float.parseFloat(width);
        float area = floatLength * floatWidth;
        float perimeter = (2*floatLength) + (2*floatWidth);
        
        // We use the f on our numbers to tell the compliler to treat them
        // as float values.
        float glassCost = 3.5f * area; // area = length * width
        float trimCost = 2.25f * perimeter; // perimeter = 2length + 2width
        
        System.out.println("Window height = " + length);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + area);
        System.out.println("Window perimeter = " + perimeter);
        System.out.println("Total cost = " + (glassCost+trimCost));
        
    }
    
}
