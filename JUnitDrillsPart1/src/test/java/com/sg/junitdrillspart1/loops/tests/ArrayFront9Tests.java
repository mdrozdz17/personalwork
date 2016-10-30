/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.loops.tests;

import com.sg.junitdrillspart1.loops.ArrayFront9;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ArrayFront9Tests {
    ArrayFront9 af9 = new ArrayFront9();
    public ArrayFront9Tests() {
    }

 @Test
    public void _09arrayFront9() {
        assert af9.arrayFront9(new int[]{1, 2, 9, 3, 4});
        assert !af9.arrayFront9(new int[]{1, 2, 3, 4, 9});
        assert !af9.arrayFront9(new int[]{1, 2, 3, 4, 5});
}
}
