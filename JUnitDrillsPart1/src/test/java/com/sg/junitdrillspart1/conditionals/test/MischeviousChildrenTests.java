/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.MischeviousChildren;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class MischeviousChildrenTests {
    
    public MischeviousChildrenTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
@Test
public void testAreWeInTrouble() {
MischeviousChildren myChildren = new MischeviousChildren();
assertTrue(myChildren.areWeInTrouble(true, true));  //-> true
assertTrue(myChildren.areWeInTrouble(false,false)); //-> true
assertFalse(myChildren.areWeInTrouble(true, false)); // -> false

}
}