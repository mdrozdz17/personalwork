/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.copyingarrays;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class CopyingArrays {
    public static void main(String[] args) {
        
        // define 2 arrays each with 10 numbes in length
        int [] array1 = new int [10];
        int [] array2 = new int [10];
        
        // count for array 1 from 0 - 9
        for (int i =  0; i < array1.length; i++) {
        
            // Random numbers for 1 - 100
        Random r = new Random();
        int randomNumber = 1 + r.nextInt(100);
        
        // Assign Array1 10 random numbers
        array1[i] = randomNumber;
    
        }
        
        // count for array 2 from 0 - 9
       for (int i =  0; i < array2.length; i++) {
        
         // Assign array2 10 random numbers as well
        array2[i] = array1[i];
       }
       
       // print out Array 1
        System.out.print("Array1: ");
        
        //Assign Array1 spot 9 the number - 7
        array1[9] = -7;
        
        for (int value: array1){
            
            System.out.print(value + " ");
        }
        
        System.out.println();
        System.out.print("Array 2: ");
        
        for (int value2 : array2){
    
            System.out.print(value2 + " ");
        
       
    }
}
}  
