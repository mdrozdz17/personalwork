/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.ParrotTrouble;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ParrotTroubleTests {

    public ParrotTroubleTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testParrotTrouble() {
        ParrotTrouble myParrot = new ParrotTrouble();

        assertTrue(myParrot.parrotTrouble(true, 6)); //parrotTrouble(true, 6) -> true
        assertFalse(myParrot.parrotTrouble(true, 7));//parrotTrouble(true, 7) -> false
        assertFalse(myParrot.parrotTrouble(false, 6));//parrotTrouble(false, 6) -> false

    }
}
