/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals1;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class StateCapitals {

    String capital;
    String state;

    public void run() {
        
        HashMap< String, String> capitals = new HashMap<>();

        capitals.put("Alabama", "Montgomery");
        capitals.put("Alaska", "Juneau");
        capitals.put("Arizona", "Phoenix");
        capitals.put("Arkansas", "Little Rock");
        capitals.put("California", "Sacramento");
        capitals.put("Colorado", "Denver");
        capitals.put("Connecticut", "Hartford");
        capitals.put("Delaware", "Dover");
        capitals.put("Florida", "Tallahassee");
        capitals.put("Georgia", "Atlanta");
        capitals.put("Hawaii", "Honolulu");
        capitals.put("Idaho", "Boise");
        capitals.put("Illinois", "Springfield");
        capitals.put("Indiana", "Indianapolis");
        capitals.put("Iowa", "Des Moines");
        capitals.put("Kansas", "Topeka");
        capitals.put("Kentucky", "Frankfort");
        capitals.put("Louisiana", "Baton Rouge");
        capitals.put("Maine", "Augusta");
        capitals.put("Maryland", "Annapolis");
        capitals.put("Massachusetts", "Boston");
        capitals.put("Michigan", "Lansing");
        capitals.put("Minnesota", "Saint Paul");
        capitals.put("Mississippi", "Jackson");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Montana", "Helena");
        capitals.put("Nebraska", "Lincoln");
        capitals.put("Nevada", "Carson City");
        capitals.put("New Hampshire", "Concord");
        capitals.put("New Jersey", "Trenton");
        capitals.put("New Mexico", "Santa Fe");
        capitals.put("New York", "Albany");
        capitals.put("North Carolina", "Raleigh");
        capitals.put("North Dakota", "Bismarck");
        capitals.put("Ohio", "Columbus");
        capitals.put("Oklahoma", "Oklahoma City");
        capitals.put("Oregon", "Salem");
        capitals.put("Pennsylvania", "Harrisburg");
        capitals.put("Rhode Island", "Providence");
        capitals.put("South Carolina", "Columbia");
        capitals.put("South Dakota", "Pierre");
        capitals.put("Tennessee", "Nashville");
        capitals.put("Texas", "Austin");
        capitals.put("Utah", "Salt Lake City");
        capitals.put("Vermont", "Montpelier");
        capitals.put("Virginia", "Richmond");
        capitals.put("Washington", "Olympia");
        capitals.put("West Virginia", "Charleston");
        capitals.put("Wisconsin", "Madison");
        capitals.put("Wyoming", "Cheyenne");

        printOut(capitals); // method to print out all the states and capitals
       // do {
        userInput(capitals);
      // } while (capitals != capitals);
        }

    public void printOut(HashMap<String, String> capitals) {
        for (Entry<String, String> stateCapitals : capitals.entrySet()) {
            // getKey() gets the key part of key-value pair (Entry)
            // getValue() gets the value part of key-value pair (Entry)
            System.out.println(stateCapitals.getKey() + " : " + stateCapitals.getValue());

        }
    }

    private void userInput(HashMap<String, String> capitals) {
        //String capital.equalsIgnoreCase;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner sc = new Scanner(System.in);
        // Prompt user for State - use do while loop
      do {
        System.out.println("Please input a State and you will be told it's capital");
        state = sc.nextLine();
        System.out.println(capitals.get(state)); // Prints corresponding capital with state
        // this calls to the Hash Map (capitals) and does a .get to see if the
        // user input matches anything in the Hash Map. If not the program keeps looping.
      } while (capitals.get(state) == null);
        
        }
        
    }




