/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.StringSplosian;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class StringSplosianTests {
    StringSplosian sp = new StringSplosian();
    
    public StringSplosianTests() {
    }
    
    @Test
    public void testStringSplosion() {
        assertEquals(sp.stringSplosion("Code"), "CCoCodCode");
        assertEquals(sp.stringSplosion("abc"), "aababc");
        assertEquals(sp.stringSplosion("ab"), "aab");
    }
    
}