/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.Makes10;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Makes10Tests {

    public Makes10Tests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testsMakes10() {
        Makes10 my10 = new Makes10();

        assertTrue(my10.makes10(9, 10)); // makes10(9, 10) -> true
        assertFalse(my10.makes10(9, 9));// makes10(9, 9) -> false
        assertTrue(my10.makes10(1, 9));// makes10(1, 9) -> true

    }
}
