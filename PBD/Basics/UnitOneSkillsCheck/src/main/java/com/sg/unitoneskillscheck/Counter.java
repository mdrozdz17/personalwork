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
public class Counter {

    public static void main(String[] args) {

        toTen();
        System.out.println("----------------------------------------------");
        toN();

    }

    public static void toTen() {
        int sum;
        for (int i = 1; i <= 10; i++) {
            sum = i;
            System.out.println(sum);

        }

    }
    
    public static void toN() {
        System.out.println("0");
        System.out.println("3");
        System.out.println("8");
        System.out.println("200");
}
}
