/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.BackAround;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class BackAroundTests {
    
    public BackAroundTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    

    @Test
    public void testFrontBack() {
        BackAround myAround = new BackAround();

        // backAround("cat") -> "tcatt"
        assertEquals("tcatt", myAround.backAround("cat"));

        // backAround("Hello") -> "oHelloo"
        assertEquals("oHelloo", myAround.backAround("Hello"));

        // backAround("a") -> "aaa"
        assertEquals("aaa", myAround.backAround("a"));

    }
}