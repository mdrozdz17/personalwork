/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.controller;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class LuckySevenController {

    @RequestMapping(value = "/luckyseven", method = RequestMethod.GET)
    public String displayLuckySevenPage() {
        return "luckyseven";
    }

    @RequestMapping(value = "/luckyseven", method = RequestMethod.POST)
    public String displayLuckySevenPage(HttpServletRequest request, Map<String, Object> model) {
        DecimalFormat d = new DecimalFormat("'$'0.00");
        String myInput = request.getParameter("myInput");
        int die1; // declare dice1
        int die2; // declare dice2
        double money; // How much $ was won or lost
        double mostMoneyHeld; // Most money held by the player at one point in time
        int rollCountMax = 0; // Roll Count Max when user had the most money
        int rollCountTotal = 0; // Total number of rolls when depletion was hit

        money = Double.parseDouble(myInput);

        mostMoneyHeld = money;

        while (money > 0) {
            rollCountTotal++;

            Random rGen = new Random();
            die1 = rGen.nextInt(6) + 1;
            die2 = rGen.nextInt(6) + 1;

            if (die1 + die2 == 7) {
                money += 4; // win $4
            } else {
                money -= 1; // lose $1
            }

            if (money > mostMoneyHeld) {
                mostMoneyHeld = money;
                rollCountMax = rollCountTotal;
            }
        }

        String broke = "You were broke after " + rollCountTotal + " rolls";
        String quit = "You should have quit after " + rollCountMax
                + " rolls when you had  " + d.format(mostMoneyHeld) + ".";

        model.put("broke", broke);
        model.put("quit", quit);
        return "lsresponse";
    }

}
