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
public class Count9 {
    public int arrayCount9(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9)
                result++;
        }
        return result;
}
}
