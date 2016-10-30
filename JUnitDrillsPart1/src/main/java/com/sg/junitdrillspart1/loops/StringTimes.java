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
public class StringTimes {

public String stringTimes(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++)
            result += str;
        return result;
}
}
