/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.unitoneskillscheck;



/**
 *
 * @author apprentice
 */
public class AreTheyTrue {

    public static void main() {

    isMonday();
    }
   public static void isMonday () {
   boolean isMonday = true;
        // Shortcut conditional for booleans
        if (isMonday) {
            System.out.println("Monday Night Football!!");
        } else  {
            System.out.println("Java All Night! :(");
        }

        // Using the NOT operator
        if (!isMonday) {
            System.out.println("I hope it's almost Friday!");
        } else {
            System.out.println("No Payday!");
        }
}

}