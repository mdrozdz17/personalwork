/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic;

/**
 *
 * @author apprentice
 */
public class SkipSum {

    /*   
Given 2 ints, a and b, return their sum. However, sums in the range 10..19 
 inclusive are forbidden, so in that case just return 20. 

skipSum(3, 4) → 7
skipSum(9, 4) → 20
skipSum(10, 11) → 21
     */
    public int skipSum(int a, int b) {
        int sum = 0;
        if ((a + b) >= 10 && (a + b) <= 19) {
            sum = 20;
        } else {
            sum = a + b;
        }
        return sum;
    }
}
