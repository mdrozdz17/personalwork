/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

/**
 *
 * @author apprentice
 */
public class App {
    
    public static void main(String[] args) {
    SimpleCalculator myApp = new SimpleCalculator(); 
    myApp.run();
    
    }


 public float doAddition() {
   float num1 = 0;
   float num2 = 0;
   float sum = num1 + num2;
   return sum;
}
 
  public float doSubtration() {
   float num1 = 0;
   float num2 = 0;
   float sum = num1 - num2;
   return sum;
}
  
   public float doMultiplication() {
   float num1 = 0;
   float num2 = 0;
   float sum = num1 * num2;
   return sum;
   }
   
    public float doDivision() {
   float num1 = 0;
   float num2 = 0;
   float sum = num1 / num2;
   return sum;
}
}


    

}