/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.PosNeg;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class PosNegTests {

    public PosNegTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testNegTests() {
        PosNeg myNeg = new PosNeg();

        assertTrue(myNeg.posNeg(1, -1, false)); // posNeg(1, -1, false) -> true
        assertTrue(myNeg.posNeg(-1, 1, false));// posNeg(-1, 1, false) -> true
        assertTrue(myNeg.posNeg(-4, -5, true));// posNeg(-4, -5, true) -> true    

    }
}
