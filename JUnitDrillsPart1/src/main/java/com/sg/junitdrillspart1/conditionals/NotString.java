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
public class NotString {

    /*   
Given a String, return a new String where "not " has been added to the front. 
However, if the String already begins with "not", return the String unchanged.

Hint: Look up how to use "SubString" in c#

notString("candy") -> "not candy"
notString("x") -> "not x"
notString("not bad") -> "not bad"
     */
    public String notString(String s) {
        if (s.length() >= 3 && s.substring(0, 3).equals("not")) {
            return s;
        }
        return "not " + s;
    }
}
