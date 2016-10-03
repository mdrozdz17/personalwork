/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.CanHazTable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class CanHazTableTests {
    
     CanHazTable myTable = new CanHazTable();
    
    public CanHazTableTests() {
    }


@Test
    public void testCanHazTable2(){
        int result;
        result = myTable.canHazTable(5, 10); // canHazTable(5, 10) → 2
        assertEquals(2,result);  
        
        result = myTable.canHazTable(5, 2); // canHazTable(5, 2) → 0
        assertEquals(0,result);  
            
        result = myTable.canHazTable(5, 5);  // canHazTable(5, 5) → 1
        assertEquals(1,result);  
    }
}
