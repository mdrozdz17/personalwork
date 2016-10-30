/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.controller;

import java.text.DecimalFormat;
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
public class FlooringCalcController {
        @RequestMapping(value="/flooringcalc", method=RequestMethod.GET)
    public String displayFlooringCalcPage(){
        return "flooringcalc";
    }
    @RequestMapping(value = "/flooringcalc", method = RequestMethod.POST)
    public String displayFlooringCalcPage(HttpServletRequest request, Map<String, Object> model) {
        
        DecimalFormat d = new DecimalFormat("0.00");
        
         int billingSQFT = 20;
         double billingHours = 86;
         double billingIncrement = .25;
        
        
        String w = request.getParameter("width");
        double width = Double.parseDouble(w);
        
        String l = request.getParameter("length");
        double length = Double.parseDouble(l);
        
        String c = request.getParameter("cost");
        double cost = Double.parseDouble(c);
        
        double area = width * length;
        
        billingHours = area / billingIncrement;
        
        double laborCost = billingHours * billingIncrement;
        
        double materialCost = area * cost;
        
        double totalCost = materialCost + laborCost;
        
        
        
        
        model.put("matCost", d.format(materialCost));
        model.put("labCost", d.format(laborCost));
        model.put("totalCost", d.format(totalCost));
        
        
        return "fcresponse";
    }
}