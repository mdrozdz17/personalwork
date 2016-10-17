/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.model;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class Product {
   DecimalFormat df = new DecimalFormat("#.00");


    private Integer id;
    private String productType;
    private Double cost;
    private Double laborCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getCost() {
        return Double.valueOf(df.format(cost));
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getLaborCost() {
        return Double.valueOf(df.format(laborCost));
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

}
