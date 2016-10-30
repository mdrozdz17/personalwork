/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.Count9;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Count9Tests {
    Count9 c9t = new Count9();
    public Count9Tests() {
    }

 @Test
    public void testCount9Tests() {
        assertEquals(c9t.arrayCount9(new int[]{1, 2, 9}), 1);
        assertEquals(c9t.arrayCount9(new int[]{1, 9, 9}), 2);
        assertEquals(c9t.arrayCount9(new int[]{1, 9, 9, 3, 9}), 3);
}
}
