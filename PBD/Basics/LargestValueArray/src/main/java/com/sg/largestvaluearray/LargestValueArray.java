/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.largestvaluearray;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class LargestValueArray {
    public static void main(String[] args) {
        
    
        
        // define 2 arrays each with 10 numbes in length
        int [] largestArray = new int [10];
       
        
        // count for array 1 from 0 - 9
        for (int i =  0; i < largestArray.length; i++) {
        
            // Random numbers for 1 - 100
        Random r = new Random();
        int randomNumber = 1 + r.nextInt(100);
        
        // Assign Array1 10 random numbers
        largestArray[i] = randomNumber;
    
        }
       
       // print out Array 1
        System.out.print("Array: ");
        
       
        for (int value: largestArray){
            
            System.out.print(value + " ");
        }
        int largestValue = 0;
        
        for (int v = 0; v < largestArray.length; v++) {
          
            if(largestArray[v] > largestValue){
                largestValue = largestArray[v];
                
            }
            
        }
        System.out.println(" ");
        
        System.out.println("The largest value is " + largestValue);
        }
   
}


    
    

