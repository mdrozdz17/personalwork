/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.arrays.test;

import com.sg.junitdrillspart1.arrays.FirstLast6;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class FirstLast6Tests {

    public FirstLast6Tests() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testFirstLast6(){
     FirstLast6 myLast6 = new FirstLast6();
  
assertTrue(myLast6.firstLast6(new int[] {1, 2, 6})); //firstLast6({1, 2, 6}) -> true

assertTrue(myLast6.firstLast6(new int[] {6, 1, 2, 3})); //firstLast6({6, 1, 2, 3}) -> true

assertFalse(myLast6.firstLast6(new int[] {13, 6, 1, 2, 3})); //firstLast6({13, 6, 1, 2, 3}) -> false
    }
}
