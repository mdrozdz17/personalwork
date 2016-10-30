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
public class TipCalcController {
        @RequestMapping(value={"/tipcalc"}, method=RequestMethod.GET)
    public String displayTipCalcPage(){
        return "tipcalc";
    }
    
    @RequestMapping(value = "/tipcalc", method = RequestMethod.POST)
    public String displayTipCalcPage(HttpServletRequest request, Map<String, Object> model) {
        
         DecimalFormat d = new DecimalFormat("0.00");

        String t = request.getParameter("total");
        double total = Double.parseDouble(t);
        String ti = request.getParameter("tip");
        Double tip = Double.parseDouble(ti);

        double tipPercent = tip / 100;
        double tipAmount = total * tipPercent;

        double totalCost = total + tipAmount;

        model.put("total", d.format(total));
        model.put("tip", d.format(tip));
        model.put("tipAmount", d.format(tipAmount));
        model.put("totalCost", d.format(totalCost));
        
        return "tcresponse";
    }
}
