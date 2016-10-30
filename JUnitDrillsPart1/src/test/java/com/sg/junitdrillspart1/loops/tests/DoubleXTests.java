/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.DoubleX;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DoubleXTests {
        DoubleX dx = new DoubleX();

    public DoubleXTests() {
    }
    
    @Test
    public void testDoubleX() {

        assertTrue(dx.doubleX("axxbb"));
        assertFalse(dx.doubleX("axaxxax"));
        assertTrue(dx.doubleX("xxxxxx"));
        assertFalse(dx.doubleX("aljksdhfp"));
        assertFalse(dx.doubleX("kljdkfhx"));
    }
    
}
