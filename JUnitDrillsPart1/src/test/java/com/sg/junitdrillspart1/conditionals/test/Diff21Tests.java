/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.Diff21;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class Diff21Tests {

    public Diff21Tests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testDiff21() {
        Diff21 myDiff = new Diff21();
        int sum;

        sum = myDiff.diff21(23); // diff21(23) -> 4
        assertEquals(4, sum);

        sum = myDiff.diff21(10);// diff21(10) -> 11
        assertEquals(11, sum);

        sum = myDiff.diff21(21);// diff21(21) -> 0
        assertEquals(0, sum);
    }
}
