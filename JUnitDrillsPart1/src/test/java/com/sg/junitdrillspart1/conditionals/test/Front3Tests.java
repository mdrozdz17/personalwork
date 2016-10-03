/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.Front3;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Front3Tests {

    public Front3Tests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testFrontBack() {
        Front3 myFront = new Front3();

        // front3("Microsoft") -> "MicMicMic"
        assertEquals("MicMicMic", myFront.front3("Microsoft"));

        // front3("Chocolate") -> "ChoChoCho"
        assertEquals("ChoChoCho", myFront.front3("Chocolate"));

        // front3("at") -> "atatat"
        assertEquals("atatat", myFront.front3("at"));

    }
}
