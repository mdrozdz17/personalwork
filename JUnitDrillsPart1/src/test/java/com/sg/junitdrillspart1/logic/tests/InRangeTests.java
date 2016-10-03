/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.InRange;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class InRangeTests {

    InRange myRange = new InRange();

    @Test
    public void testsInRange() {

        assertTrue(myRange.inRange(5, false)); //inRange (5, false) → true
        assertFalse(myRange.inRange(11, false));  //inRange (11, false) → false
        assertTrue(myRange.inRange(11, true));  //inRange (11, true) → true

    }
}
