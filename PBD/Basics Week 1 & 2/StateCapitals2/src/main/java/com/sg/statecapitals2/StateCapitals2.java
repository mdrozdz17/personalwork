/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class StateCapitals2 {

    Scanner sc = new Scanner(System.in);

    public void run() {
        Scanner sc = new Scanner(System.in);
        // Evaluating with String and Capital class with Hashmap called "stateCapitals"
        HashMap< String, Capital> stateCapitals = new HashMap<>();

        stateCapitals.put("Alabama", new Capital("Montgomery", 201332, 156f));
        stateCapitals.put("Alaska", new Capital("Juneau", 32660, 3255f));
        stateCapitals.put("Arizona", new Capital("Phoenix", 1445000, 517f));
        stateCapitals.put("Arkansas", new Capital("Little Rock", 197357, 116f));

        // Method called printOut
        printOut(stateCapitals);
        System.out.println("");
        // Method called userInput
        userInput(stateCapitals);
    }
    // Method to printout States, Capitals, Population and Square Miles

    public void printOut(HashMap<String, Capital> stateCapitals) {
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");

        for (Entry<String, Capital> stateResults : stateCapitals.entrySet()) {
            // getKey() gets the key part of key-value pair (Entry)
            // getValue() gets the value part of key-value pair (Entry)
            // need to do a .getValue().getName/Pop/SquareMile to populate values from Capital.java
            System.out.println(stateResults.getKey() 
                    + " - " + stateResults.getValue().getName() 
                    + " | Pop " + stateResults.getValue().getPop() 
                    + " | Area " + stateResults.getValue().getSquareMile());

        }
    }
    // Method to allow User to Input popluation and evaluate results to Hashmap

    public void userInput(HashMap<String, Capital> stateCapitals) {
        System.out.println("Please enter the lower limit for the city population");
        int cityPop = sc.nextInt();
        int population = 0;
        System.out.println("");
        System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + cityPop);
        for (Entry<String, Capital> stateResults : stateCapitals.entrySet()) {
            // define variable population to .getPop value from Hashmap
            population = (stateResults.getValue().getPop());
            // Use if statement that looks at .getPop from Hashmap and evaluates
            // to userInput (cityPop)
            if (population >= cityPop) {
                System.out.println(stateResults.getKey()
                        + " - " + stateResults.getValue().getName()
                        + " | Pop " + stateResults.getValue().getPop()
                        + " | Area " + stateResults.getValue().getSquareMile());
            }
        }
    }
}
