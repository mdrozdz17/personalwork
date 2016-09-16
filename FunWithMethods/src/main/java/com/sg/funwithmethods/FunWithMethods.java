/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.funwithmethods;

/**
 *
 * @author apprentice
 */
public class FunWithMethods {
    public static void main(String[] args) {
         int add2Numbers = add(42,21);
         printInteger(add2Numbers);
         float add2Nums = add(1,1.2f);
    }
    
    private static String getName(){
        return "Sarah";
    }
    
    private static void printInteger(int num1){
        String name = getName();
        System.out.println(name + " : " + num1);
    }
    
    private static int add(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    
    private static int add(int firstNumber, int secondNumber, int thirdNumber){
        return firstNumber + secondNumber + thirdNumber;
    }
    
    private static float add(float firstNumber, float secondNumber){
        return firstNumber + secondNumber;
    }
    
    private static float add(float num1, int num2){
        return num1 + Float.parseFloat(Integer.toString(num2));
    }
    
    private static float add(int num1, float num2){
       return Float.parseFloat(Integer.toString(num1))+ num2;
    }
}