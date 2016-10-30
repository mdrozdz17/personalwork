/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
public class InterestCalcController {
        @RequestMapping(value="/interestcalc", method=RequestMethod.GET)
    public String displayInterestCalcPage(){
        return "interestcalc";
    }
    @RequestMapping(value = "/interestcalc", method = RequestMethod.POST)
    public String displayInterestCalcPage(HttpServletRequest request, Map<String, Object> model) {
        DecimalFormat d = new DecimalFormat("0.00");

        String intRate = request.getParameter("intRate");
        double interestRate = Double.parseDouble(intRate);
        
        String choice = request.getParameter("compound");
        
        String prinAmt = request.getParameter("principalAmt");
        double newYearPrincipal = Double.parseDouble(prinAmt);
        
        String year = request.getParameter("years");
        double years = Double.parseDouble(year);
        
        double originalPrincipal = 0;
        
        
        interestRate = returnRate(choice, interestRate);
        
        List<Integer> numberOfYears = new ArrayList();
        List<String> startPrincipal = new ArrayList();
        List<String> interest = new ArrayList();
        List<String> endPrincipal = new ArrayList();
        
        for (int i = 0; i < years; i++) {

            originalPrincipal = newYearPrincipal;

            newYearPrincipal = calcNewYearPrincipal(newYearPrincipal, interestRate);

            double interestThisYear = (newYearPrincipal - originalPrincipal);
            double endYearPrincipal = newYearPrincipal;
            
            numberOfYears.add(i+1);
            startPrincipal.add(d.format(originalPrincipal));
            interest.add(d.format(interestThisYear));
            endPrincipal.add(d.format(endYearPrincipal));
        }
        
        model.put("years", numberOfYears);
        model.put("startP", startPrincipal);
        model.put("interest", interest);
        model.put("endP", endPrincipal);
        
        return "icresponse";
}
    public double returnRate(String type, double interestRate) {

        switch (type) {
            case "q":
                interestRate = (interestRate / 4) / 100;
                break;
            case "m":
                interestRate = (interestRate / 12) / 100;
                break;
            case "d":
                interestRate = (interestRate / 365) / 100;
                break;
            default:
                break;
        }

        return interestRate;
    }
    
     public double calcNewYearPrincipal(double newYearPrincipal, double Interest) {

        for (int j = 0; j < 4; j++) {

            newYearPrincipal += (newYearPrincipal * Interest);

        }
        return (newYearPrincipal);
    }

}