/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.arrays.test;

import com.sg.junitdrillspart1.arrays.MakePi;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class MakePiTests {

    @Test
    public void testMakePi() {
        MakePi myPi = new MakePi();
        int n = 3;
        int[] array = {3, 1, 4};
        int[] result = myPi.makePi(n);
        Assert.assertArrayEquals(array, result);
    }
}
