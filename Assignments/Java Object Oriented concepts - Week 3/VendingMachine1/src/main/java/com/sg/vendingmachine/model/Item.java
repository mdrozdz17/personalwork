/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.model;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class Item {
 DecimalFormat d = new DecimalFormat("0.00");
    private String name;
    private double cost;
    private int numInInventory;
    private int itemId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return Double.valueOf(d.format(cost));
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumInInventory() {
        return numInInventory;
    }

    public void setNumInInventory(int numInInventory) {
        this.numInInventory = numInInventory;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
