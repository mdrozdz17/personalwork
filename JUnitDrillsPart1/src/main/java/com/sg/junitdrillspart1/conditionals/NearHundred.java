/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals;

/**
 *
 * @author apprentice
 */
public class NearHundred {

    /*
Given an int n, return true if it is within 10 of 100 or 200.
Hint: Check out the Math class for absolute value

nearHundred(103) -> true
nearHundred(90) -> true
nearHundred(89) -> false
     */

    public boolean nearHundred(int n) {

        if ((Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10)) {
            return true;
        } else {
            return false;
        }
    }
}
