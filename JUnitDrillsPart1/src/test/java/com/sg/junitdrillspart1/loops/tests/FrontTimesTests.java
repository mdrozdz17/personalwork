/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.FrontTimes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class FrontTimesTests {

    FrontTimes ft = new FrontTimes();

    public FrontTimesTests() {
    }

    @Test
    public void testFrontTimes() {
        assertEquals(ft.frontTimes("Chocolate", 2), "ChoCho");
        assertEquals(ft.frontTimes("Chocolate", 3), "ChoChoCho");
        assertEquals(ft.frontTimes("Abc", 3), "AbcAbcAbc");
        assertEquals(ft.frontTimes("A", 3), "AAA");

    }

}
