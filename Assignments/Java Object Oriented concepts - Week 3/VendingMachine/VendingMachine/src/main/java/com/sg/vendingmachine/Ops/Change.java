/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.Ops;
import com.sg.vendingmachine.controller.ItemController;



/**
 *
 * @author apprentice
 */
public class Change {
    private double amount;
    private double pennies;
    private double nickels;
    private double dimes;
    private double quarters;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPennies() {
        return pennies;
    }

    public void setPennies(double pennies) {
        this.pennies = pennies;
    }

    public double getNickels() {
        return nickels;
    }

    public void setNickels(double nickels) {
        this.nickels = nickels;
    }

    public double getDimes() {
        return dimes;
    }

    public void setDimes(double dimes) {
        this.dimes = dimes;
    }

    public double getQuarters() {
        return quarters;
    }

    public void setQuarters(double quarters) {
        this.quarters = quarters;
    }
}
