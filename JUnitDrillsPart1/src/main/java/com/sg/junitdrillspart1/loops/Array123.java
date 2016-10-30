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
public class Array123 {
    public boolean array123(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++)
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3)
                return true;
        return false;
}

}
