package com.sg.junitdrillspart1.logic.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sg.junitdrillspart1.logic.CaughtSpeeding;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class CaughtSpeedingTests {

    CaughtSpeeding mySpeed = new CaughtSpeeding();

    @Test
    public void CaughtSpeedingTests() {
        int result;

        result = mySpeed.caughtSpeeding(60, false);  // caughtSpeeding(60, false) → 0
        assertEquals(0, result);

        result = mySpeed.caughtSpeeding(65, false);    // caughtSpeeding(65, false) → 1 
        assertEquals(1, result);

        result = mySpeed.caughtSpeeding(65, true); // caughtSpeeding(65, true) → 0
        assertEquals(0, result);

    }
}
