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
public class Tax {
    DecimalFormat df = new DecimalFormat("#.00");

    private Integer id;
    private String stateName;
    private Double taxRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Double getTaxRate() {
        return Double.valueOf(df.format(taxRate));
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

}
