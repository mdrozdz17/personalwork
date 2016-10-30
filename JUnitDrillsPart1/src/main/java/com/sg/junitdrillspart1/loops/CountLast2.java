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
public class CountLast2 {
    public int last2(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 2).equals(
                                str.substring(str.length() - 2)))
                    count++;
        }
        return count;
}
}
