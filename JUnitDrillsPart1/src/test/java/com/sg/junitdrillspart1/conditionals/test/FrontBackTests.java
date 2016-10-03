/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.FrontBack;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class FrontBackTests {

    @Test
    public void testFrontBack() {
        FrontBack myBack = new FrontBack();

        //// frontBack("code") -> "eodc"
        assertEquals("eodc", myBack.frontBack("code"));

        // frontBack("a") -> "a"
        assertEquals("a", myBack.frontBack("a"));

        // frontBack("ab") -> "ba"
        assertEquals("ba", myBack.frontBack("ab"));

    }
}
