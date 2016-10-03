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
public class LoveSix {

    /*
The number 6 is a truly great number. Given two int values, a and b, return true 
    if either one is 6. Or if their sum or difference is 6.

loveSix(6, 4) → true
loveSix(4, 5) → false
loveSix(1, 5) → true
     */
    public boolean loveSix(int a, int b) {
        boolean result;
        if (a == 6 || b == 6) { // if a or b = 6 return true
            result = true;
        } else if (a + b == 6) { // if a and b = 6 return true
            return true;
        } else if (a - b == 6) { // if a - b = 6 return true
            return true;
        } else { // if anything else return false
            result = false;
        }
        return result;
    }

}
