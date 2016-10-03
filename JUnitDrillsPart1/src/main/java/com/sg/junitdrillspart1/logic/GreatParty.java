/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic;

/**
 *
 * @author parallels
 */
public class GreatParty {

    /*
    When squirrels get together for a party, they like to have cigars. A squirrel party is successful 
when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case 
there is no upper bound on the number of cigars. Return true if the party with the given values is 
successful, or false otherwise. 

     */
    public boolean greatParty(int cigars, boolean isWeekend) {
        // Cigars and Weekends
        // More often than not, it's not a great party - so this is our default
        boolean isGreatParty = false;
        // If cigars is between 40 and 60 inclusive during the week - great party
        if ((cigars >= 40 && cigars <= 60) && !isWeekend) {
            isGreatParty = true;
        } else if (isWeekend && cigars >= 40) {
            // If it's the weekend, we need at least 40 cigars, but no upperbound
            isGreatParty = true;
        }
        return isGreatParty;
    }

}