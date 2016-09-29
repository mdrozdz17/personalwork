/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.findingthelargestvalueinanarray;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class FindingTheLargestValueInAnArray {
    
        // define 2 arrays each with 10 numbes in length
        int [] largestArray = new int [10];
       
        
        // count for array 1 from 0 - 9
        for int x = 0; x < largestArray.length; x++) {
        for (int i =  0; i < largestArray.length; i++) {
        
            // Random numbers for 1 - 100
        Random r = new Random();
        int randomNumber = 1 + r.nextInt(100);
        
        // Assign Array1 10 random numbers
        array1[i] = randomNumber;
    
        }
       
       // print out Array 1
        System.out.print("Array1: ");
        
       
        for (int value: array1){
            
            System.out.print(value + " ");
        }
        

int findMaximum(int arr[], int low, int high)
{
   int max = arr[low];
   int i;
   for (i = low; i <= high; i++)
   {
       if (arr[i] > max)
          max = arr[i];
   }
   return max;
}
}
