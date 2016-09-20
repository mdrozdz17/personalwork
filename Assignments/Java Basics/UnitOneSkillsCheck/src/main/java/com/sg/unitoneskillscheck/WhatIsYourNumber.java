/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.unitoneskillscheck;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WhatIsYourNumber {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int userInput;
        
        System.out.println("Please input an integer");
        userInput = sc.nextInt();
      int i = userInput;
        while(i > 0){
                 i--;
                 System.out.println(i);
}

    
    
}
}
    
