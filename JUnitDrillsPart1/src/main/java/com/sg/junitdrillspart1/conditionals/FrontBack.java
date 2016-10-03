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
public class FrontBack {

    /*
Given a String, return a new String where the first and last chars have been exchanged. 

frontBack("code") -> "eodc"
frontBack("a") -> "a"
frontBack("ab") -> "ba"

     */

    public String frontBack(String str) {

        if (str.length() <= 1) {
            return str;
        }

        String mid = str.substring(1, str.length() - 1);

        return str.charAt(str.length() - 1) + mid + str.charAt(0);
    }
}
