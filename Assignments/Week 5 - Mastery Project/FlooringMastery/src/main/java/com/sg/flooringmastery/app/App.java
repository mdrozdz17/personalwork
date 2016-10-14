package com.sg.flooringmastery.app;


import com.sg.flooringmastery.controller.FlooringMasteryController;
import java.io.IOException;
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class App {
        public static void main(String[] args) throws IOException, ParseException {
        FlooringMasteryController controller = new FlooringMasteryController();
        controller.run();
    }
    
}
