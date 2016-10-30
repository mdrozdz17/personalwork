/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.controller;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class FactorizorController {

    @RequestMapping(value = "/factorizor", method = RequestMethod.GET)
    public String displayFactorizorPage() {
        return "factorizor";
    }

    @RequestMapping(value = "/factorizor", method = RequestMethod.POST)
    public String displayFactorizorPage(HttpServletRequest request, Map<String, Object> model) {
        String myInput = request.getParameter("myInput");
        int number;
        number = Integer.parseInt(myInput);
        int factorSum = 0;

        ArrayList<Integer> factors = new ArrayList();

        for (int i = 1; i < number; i++) {

            if (number % i == 0) {
                factors.add(i); // can't sout so must use an ArrayList
                factorSum = factorSum + i;

            }
        }
        String message1 = "";
        String message2 = "";
        String message3 = ("The factors of " + number + " are:");

        // If input number = 1 and itself than the number is Perfect otherwise it is not.
        if (number == factorSum) {
            message1 = (number + " is Perfect!");
        } else {
            message1 = (number + " is not Perfect!");

        }

        // If input number = 1 than the number is Prime otherwise it is not.
        if (factorSum == 1) {
            message2 = (number + " is Prime!");
        } else {
            message2 = (number + " is not Prime!");
        }
        model.put("prime", message1);
        model.put("perfect", message2);
        model.put("factors", factors);

        return "factresponse";
    }
}
