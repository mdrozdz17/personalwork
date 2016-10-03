/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.LoveSix;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 *
 * @author apprentice
 */
public class LoveSixTests {
    LoveSix myLove = new LoveSix();

@Test
    public void testLoveSix() {
        boolean result;
        result = myLove.loveSix(6, 4); // loveSix(6, 4) → true
        assertTrue(result);

        result = myLove.loveSix(4, 5); // loveSix(4, 5) → false
        assertFalse(result);
        
        result = myLove.loveSix(1, 5); // loveSix(1, 5) → true
        assertTrue(result);
    }
}



