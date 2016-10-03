/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.conditionals;

/**
 *
 * @author apprentice
 */
public class Multiple3Or5 {
 /*Return true if the given non-negative number is a multiple of 3 or a 
multiple of 5. Use the % "mod" operator

multiple3or5(3) -> true
multiple3or5(10) -> true
multiple3or5(8) -> false
*/

public boolean multiple3or5(int number) {
    // By default; I'm skeptical about everything
    boolean isMultiple3or5 = false;
    // If the given is a multiple of 3 or 5, we need to flip isMultiple to true
    if (number % 3 == 0 || number % 5 ==0){
        isMultiple3or5 = true;
    }
    return isMultiple3or5;
}
    // same logic as above, with alot less code
    // The rexpression following return evaluates to a boolean
    // Since that expression evaulates to a boolean, we can return that evaluatee value
    public boolean multiple3or5a(int number) {
        return(number % 3 == 0 || number % 5 == 0);
}
}
