/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.SkipSum;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author apprentice
 */
public class SkipSumTests {
    SkipSum mySum = new SkipSum();

    @Test
    public void testSkipSum(){
        int sum;
        sum = mySum.skipSum(3, 4); // skipSum(3, 4) → 7
        assertEquals(7,sum);  
        
        sum = mySum.skipSum(9, 4); // skipSum(9, 4) → 20
        assertEquals(20,sum);  
            
        sum = mySum.skipSum(10, 11);  // skipSum(10, 11) → 21
        assertEquals(21,sum);  
    }
}
