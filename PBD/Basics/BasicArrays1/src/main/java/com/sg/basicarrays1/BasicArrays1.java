/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.basicarrays1;

/**
 *
 * @author apprentice
 */
public class BasicArrays1 {
    
     public static void main(String[] args) {
     
     int[] integer = new int[10];
     integer[0] = -113;
     integer[1] = -113;
     integer[2] = -113;
     integer[3] = -113;
     integer[4] = -113;
     integer[5] = -113;
     integer[6] = -113;
     integer[7] = -113;
     integer[8] = -113;
     integer[9] = -113;
     
     printOutIntArray(integer);

       
       
     
    }
    

     public static void printOutIntArray(int[] integer) {
        System.out.println("---------------------------------");
        // numbers is pulled from "integer" to get 10 positions
        for (int i = 0; i < integer.length; i++) { // "i" is the position in the array
            System.out.println("Slot " + i + " contains a " + integer[i]);
        }
     }
}
