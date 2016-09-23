/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals2 {
 Scanner sc = new Scanner(System.in); 


    public void run() {
         Scanner sc = new Scanner(System.in);
        
        HashMap< String, Capital> stateCapitals = new HashMap<>();

        stateCapitals.put("Alabama",new Capital("Montgomery",201332, 156f));
        stateCapitals.put("Alaska",new Capital("Juneau",32660, 3255f));
        stateCapitals.put("Arizona",new Capital("Phoenix",1445000, 517f));
        stateCapitals.put("Arkansas",new Capital("Little Rock",197357, 116f));
        
        printOut(stateCapitals);
        System.out.println("");
        userInput(stateCapitals);
    }
        public void printOut(HashMap<String, Capital> stateCapitals) {
            System.out.println("STATE/CAPITAL PAIRS:"); 
            System.out.println("====================");

        for (Entry<String, Capital> stateResults : stateCapitals.entrySet()) {
            // getKey() gets the key part of key-value pair (Entry)
            // getValue() gets the value part of key-value pair (Entry)
            // need to do a .getValue().getName/Pop/SquareMile to populate values from Capital.java
            System.out.println(stateResults.getKey() + " - " + stateResults.getValue().getName() + " | Pop " + stateResults.getValue().getPop()+ " | Area " + stateResults.getValue().getSquareMile());

        }
    }
        public void userInput(HashMap<String, Capital> stateCapitals) {
         Set<String> keyset = stateCapitals.keySet();
        System.out.println("Please enter the lower limit for the city population");
        int cityPop = sc.nextInt();
        int population;
      // Set<String> keys = stateCapitals.keySet();
       // for(String key: keys) {
            System.out.println("");
         
        
           System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + cityPop);

        for (Entry<String, Capital> stateResults : stateCapitals.entrySet()) {
        //for (String s : keyset)
            
        population = (stateCapitals.get(s)).getPop();
        if (cityPop < stateResults.getValue().getPop()); {
           System.out.println(cityPop < stateResults.getValue().getPop());
        System.out.println(cityPop + " population is greater than " + stateResults.getKey() + " - " + stateResults.getValue().getPop());
       // System.out.println(stateResults.getKey() + " - " + stateResults.getValue().getName() + " | Pop " + stateResults.getValue().getPop()+ " | Area " + stateResults.getValue().getSquareMile());
        }
        
       // enchanced for loop 
       // have an if statement that looks at .getPop
       //for (Entry<String, Capital> stateResults : stateCapitals.entrySet()) {
       // System.out.println("Value of " + key + "is " + stateCapitals.get(key));
        }
        }
}




        
    
    
    

