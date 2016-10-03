/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic;

/**
 *
 * @author apprentice
 */
public class PlayOutside {

    /*
 The children in Cleveland spend most of the day playing outside. In particular, 
 they play if the temperature is between 60 and 90 (inclusive). Unless it is 
 summer, then the upper limit is 100 instead of 90. Given an int temperature and 
 a boolean isSummer, return true if the children play and false otherwise. 

playOutside(70, false) → true
playOutside(95, false) → false
playOutside(95, true) → true
     */

    public boolean playOutside(int temp, boolean isSummer) {
        // Temperature and Summer
        // More often than not, it's not a great party - so this is our default
        boolean isPlayOutside = false;
        // If cigars is between 40 and 60 inclusive during the week - great party
        if ((temp >= 60 && temp <= 90) && !isSummer) {
            isPlayOutside = true;
        } else if (isSummer && temp <= 100) {
            // If it's Summer and upper limit is 100
            isPlayOutside = true;
        }
        return isPlayOutside;
    }

}
