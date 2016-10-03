/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.SleepingIn;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class SleepingInTests {
    
    public SleepingInTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
@Test
public void testsSleepingIn(){
SleepingIn mySleep = new SleepingIn();
 assertTrue(mySleep.canSleepIn(false,false)); // canSleepIn(false, false) -> true
 assertFalse(mySleep.canSleepIn(true,false)); // canSleepIn(true, false) -> false
 assertTrue(mySleep.canSleepIn(false,true));  // canSleepIn(false, true) -> true
}
}