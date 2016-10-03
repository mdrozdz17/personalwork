/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.PlayOutside;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class PlayOutsideTests {
        PlayOutside myPlay = new PlayOutside();
    
    /*public PlayOutsideTests() {
    }

    // Step 1. Add the tests
    //  - Right click the Source Packages
    //  - New.... Other
    //  - Category: Unit Tests, File: JUnit Test
    //  - In the drop down, make sure Test Packages is selected
    @Test
    public void testPlayOutside(){
        // Step 2. Copy the test cases from the Drills file
        // greatParty(30, false) → false
        
        // Step 3. Do the Arrange - Act - Assert for the first case
        
        // Arrange - set up given conditions
        int numOfCigars = 30;
        boolean isWeekend = false;
        boolean expectedResult = false;
              
        // Act - get the actual result
        boolean actualResult = myPlay.playOutside(temp, isSummer);
        
        // Assert - make sure that actual and expected match
        assertEquals(expectedResult,actualResult);
         
        
    }
*/
    
    @Test
    public void testGreatParty2(){
        
        assertTrue(myPlay.playOutside(70, false));  // playOutside(70, false) → true
       
        
        assertFalse(myPlay.playOutside (95,false));    //playOutside(95, false) → false
       
        
        assertTrue(myPlay.playOutside(95, true)); //playOutside(95, true) → true
    }
}
