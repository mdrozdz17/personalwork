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
public class FrontTimes {
    public String frontTimes(String str, int n) {
        String result = "";
        if (str.length() <= 3)
            for (int i = 0; i < n; i++)
                result += str;
        else
            for (int i = 0; i < n; i++)
                result += str.substring(0, 3);
        return result;
}
}
