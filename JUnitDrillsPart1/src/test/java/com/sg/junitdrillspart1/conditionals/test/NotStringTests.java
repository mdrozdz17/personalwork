/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.NotString;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class NotStringTests {

    public NotStringTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testNotString() {
        NotString myString = new NotString();
        
        String result;
        
        result = myString.notString("candy"); // -> "not candy"
        assertEquals("not candy", result);

        result = myString.notString("x"); // -> "not x"
        assertEquals("not x", result);

        result = myString.notString("not bad");  // -> "not bad"
        assertEquals("not bad", result);
    }
}
