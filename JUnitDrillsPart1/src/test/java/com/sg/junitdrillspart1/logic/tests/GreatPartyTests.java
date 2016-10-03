/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.GreatParty;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author parallels
 */
public class GreatPartyTests {

    GreatParty myParty = new GreatParty();
    
    public GreatPartyTests() {
    }

    // Step 1. Add the tests
    //  - Right click the Source Packages
    //  - New.... Other
    //  - Category: Unit Tests, File: JUnit Test
    //  - In the drop down, make sure Test Packages is selected
    @Test
    public void testGreatParty(){
        // Step 2. Copy the test cases from the Drills file
        // greatParty(30, false) → false
        
        // Step 3. Do the Arrange - Act - Assert for the first case
        
        // Arrange - set up given conditions
        int numOfCigars = 30;
        boolean isWeekend = false;
        boolean expectedResult = false;
              
        // Act - get the actual result
        boolean actualResult = myParty.greatParty(numOfCigars, isWeekend);
        
        // Assert - make sure that actual and expected match
        assertEquals(expectedResult,actualResult);
         
        
    }
    
    @Test
    public void testGreatParty2(){
        boolean result;
        
        result = myParty.greatParty(50, false);  // greatParty(50, false) → true
        assertTrue(result);
        
        result = myParty.greatParty(70,true);    //greatParty(70, true) → true
        assertTrue(result);
        
        assertFalse(myParty.greatParty(30, false)); // greatParty(30, false) → false
    }
}