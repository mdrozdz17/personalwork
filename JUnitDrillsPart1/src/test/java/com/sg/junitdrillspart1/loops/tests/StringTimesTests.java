/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.StringTimes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class StringTimesTests {
    
    public StringTimesTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void _01stringTimes() {
        StringTimes st = new StringTimes();
        assertEquals(st.stringTimes("Hi", 2), "HiHi");
        assertEquals(st.stringTimes("Hi", 3), "HiHiHi");
        assertEquals(st.stringTimes("Hi", 1), "Hi");
    }
}
