/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops;

/**
 *
 * @author apprentice
 */
public class DoubleX {
   public boolean doubleX(String str) {
        int firstX = str.indexOf('x');
        if (firstX < str.length() - 1)
            return str.charAt(firstX + 1) == 'x';
        return false;
}
}
