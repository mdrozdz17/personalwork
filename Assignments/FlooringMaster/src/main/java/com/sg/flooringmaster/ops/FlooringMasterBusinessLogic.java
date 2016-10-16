/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.ops;



/**
 *
 * @author apprentice
 */
public class FlooringMasterBusinessLogic {
    
     public Double materialTotal(double area, double productCost) {

        double materialTotal = area * productCost;

        materialTotal = Math.round(materialTotal * 100);
        materialTotal = materialTotal / 100;

        return materialTotal;

    }

    public Double laborTotal(double area, double laborCost) {

        double laborTotal = area * laborCost;

        laborTotal = Math.round(laborTotal * 100);
        laborTotal = laborTotal / 100;

        return laborTotal;
    }

    public Double tax(double area, double tax, double laborCost, double productCost) {

        tax = tax * 0.01;

        double laborTotal = laborCost * area;

        double productTotal = productCost * area;

        double costBeforeTax = laborTotal + productTotal;

        double totalTax = tax * costBeforeTax;

        totalTax = Math.round(totalTax * 100);
        totalTax = totalTax / 100;

        return totalTax;
    }

    public Double total(double tax, double labor, double product) {

        tax = tax * 0.01;

        double costBeforeTax = labor + product;

        double totalTax = tax * costBeforeTax;

        double grandTotal = totalTax + labor + product;

        grandTotal = Math.round(grandTotal * 100);

        return grandTotal;
    }
}
    

