/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals.test;

import com.sg.junitdrillspart1.conditionals.SumDouble;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class SumDoubleTests {

    public SumDoubleTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testSumDouble() {
        SumDouble mySum = new SumDouble();
        int sum;
        sum = mySum.sumDouble(1, 2); //sumDouble(1, 2) -> 3
        assertEquals(3, sum);

        sum = mySum.sumDouble(3, 2); //sumDouble(3, 2) -> 5
        assertEquals(5, sum);

        sum = mySum.sumDouble(2, 2); //sumDouble(2, 2) -> 8
        assertEquals(8, sum);

    }
}
