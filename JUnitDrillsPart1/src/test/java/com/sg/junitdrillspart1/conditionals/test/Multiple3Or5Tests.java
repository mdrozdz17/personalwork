/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.Multiple3Or5;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Multiple3Or5Tests {

    public Multiple3Or5Tests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testMultiple3Or5() {
        // Created an instance of the class where our code will live
        Multiple3Or5 myMultiples = new Multiple3Or5();  
        // Calling the method that we have in our class
        // Note: We will fill in this method afterwards
        // For now, we're taking a test-first approach
        assertTrue(myMultiples.multiple3or5(3)); 
        assertTrue(myMultiples.multiple3or5(10));
        assertFalse(myMultiples.multiple3or5(8));
    }
}


