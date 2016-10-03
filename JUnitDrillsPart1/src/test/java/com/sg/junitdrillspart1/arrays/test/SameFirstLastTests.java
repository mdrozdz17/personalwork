/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.arrays.test;

import com.sg.junitdrillspart1.arrays.SameFirstLast;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class SameFirstLastTests {

    public SameFirstLastTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testSameFirstLast() {
        SameFirstLast myFirstLast = new SameFirstLast();

        assertFalse(myFirstLast.sameFirstLast(new int[]{1, 2, 3})); //sameFirstLast({1, 2, 3}) -> false

        assertTrue(myFirstLast.sameFirstLast(new int[]{1, 2, 3, 1})); //sameFirstLast({1, 2, 3, 1}) -> true

        assertTrue(myFirstLast.sameFirstLast(new int[]{1, 2, 1})); //sameFirstLast({1, 2, 1}) -> true
    }
}
