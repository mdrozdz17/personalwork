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
public class ArrayFront9 {
    public boolean arrayFront9(int[] nums) {
        int check = (nums.length < 4) ? nums.length : 4;
        for (int i = 0; i < check; i++) {
            if (nums[i] == 9) return true;
        }
        return false;
}
}
