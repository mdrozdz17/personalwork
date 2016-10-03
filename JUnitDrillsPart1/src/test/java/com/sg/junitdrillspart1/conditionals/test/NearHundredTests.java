/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.NearHundred;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class NearHundredTests {

    public NearHundredTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     *
     */
    @Test
    public void testHundredTests() {
        NearHundred myHundred = new NearHundred();

        assertTrue(myHundred.nearHundred(103)); // nearHundred(103) -> true
        assertTrue(myHundred.nearHundred(90));// nearHundred(90) -> true
        assertFalse(myHundred.nearHundred(89));// nearHundred(89) -> false
    }
}
