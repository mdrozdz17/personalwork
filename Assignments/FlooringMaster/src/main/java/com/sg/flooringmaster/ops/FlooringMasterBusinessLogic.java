/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.ops;

import java.text.DecimalFormat;
import java.text.NumberFormat;



/**
 *
 * @author apprentice
 */
public class FlooringMasterBusinessLogic {
      DecimalFormat df = new DecimalFormat("#.00");

    
     public Double materialTotal(double area, double productCost) {
         

        double materialTotal = area * productCost;

        materialTotal = materialTotal * 100;
        materialTotal = materialTotal / 100;

        return Double.valueOf(df.format(materialTotal));

    }

    public Double laborTotal(double area, double laborCost) {

        double laborTotal = area * laborCost;

        laborTotal = laborTotal * 100;
        laborTotal = laborTotal / 100;

        return Double.valueOf(df.format(laborTotal));
    }

    public Double tax(double area, double tax, double laborCost, double productCost) {

        tax = tax * 0.01;

        double laborTotal = laborCost * area;

        double productTotal = productCost * area;

        double costBeforeTax = laborTotal + productTotal;

        double totalTax = tax * costBeforeTax;

        totalTax = totalTax * 100;
         totalTax = totalTax / 100;

        return Double.valueOf(df.format(totalTax));
    }

    public Double total(double tax, double labor, double product) {

        tax = tax * 0.01;

        double costBeforeTax = labor + product;

        double totalTax = tax * costBeforeTax;

        double grandTotal = totalTax + labor + product;

        grandTotal = (grandTotal * 100) * 10;

        return Double.valueOf(df.format(grandTotal));
    }
}
    

