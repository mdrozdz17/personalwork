/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Array123 {
    Array123 a123 = new Array123();
    public Array123() {
    }

@Test
    public void testArray123() {
        assertTrue(a123.array123(new int[]{1, 1, 2, 3, 1}));
        assertFalse(123.array123(new int[]{1, 1, 2, 4, 1}));
        assertTrue(a123.array123(new int[]{1, 1, 2, 1, 2, 3}));
    }
}