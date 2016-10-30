/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.CountLast2;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class CountLast2Tests {
    CountLast2 cl2 = new CountLast2();
    public CountLast2Tests() {
    }
@Test
public void testCountLast2() {
        assertEquals(cl2.last2("hixxhi"), 1);
        assertEquals(cl2.last2("xaxxaxaxx"), 1);
        assertEquals(cl2.last2("axxxaaxx"), 2);
}
}