/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.basicarrays2;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BasicArrays2 {
   
    public static void main(String[] args) {
     
    int[] integer = new int[10];
 
for (int i = 0; i < integer.length; i++) {
     Random rGen = new Random();
      integer[i] = rGen.nextInt(100) + 1;
      System.out.println("Slot " + i + " contains " + integer[i]);
    }
}
}
