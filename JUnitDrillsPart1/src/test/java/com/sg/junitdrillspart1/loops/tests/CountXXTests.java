/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.CountXX;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class CountXXTests {
    CountXX cxx = new CountXX();
    
    public CountXXTests() {
    }
    
    @Test
    public void testCountXX() {
        assertEquals(cxx.countXX("abcxx"), 1);
        assertEquals(cxx.countXX("xxx"), 2);
        assertEquals(cxx.countXX("xxxx"), 3);
    }
    
}