/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator2;

/**
 *
 * @author apprentice
 */
public class SimpleCalculator2 {
    
    int sum;

    public float doAddition(int num1, int num2) {
        sum = num1 + num2;
        return sum;
    }

    public float doSubtration(int num1,int num2) {
        sum = num1 - num2;
        return sum;
    }

    public float doMultiplication(int num1, int num2) {
        sum = num1 * num2;
        return sum;
    }

    public float doDivision(int num1, int num2) {
      
        try {
        sum = num1/num2;
        } catch (Exception ex) { 
            System.out.println("Not divisible by 0. Please try again");
       
    }
        return sum;
    }
}

