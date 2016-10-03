/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.MissingChar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class MissingCharTests {

    public MissingCharTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testMissingChar() {
        MissingChar myChar = new MissingChar();

        assertEquals("ktten", myChar.missingChar("kitten", 1));
        assertEquals("itten", myChar.missingChar("kitten", 0));
        assertEquals("kittn", myChar.missingChar("kitten", 4));

    }
}
