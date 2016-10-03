/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.SpecialEleven;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class SpecialElevenTests {
     SpecialEleven mySpecial = new SpecialEleven();
    
     @Test
    public void testSpecialEleven(){
    assertTrue(mySpecial.specialEleven(22));  // specialEleven(22) → true
    assertTrue(mySpecial.specialEleven(23));  // specialEleven(23) → true
    assertFalse(mySpecial.specialEleven(24)); // specialEleven(24) → false
}
}
