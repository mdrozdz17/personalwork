/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

/**
 *
 * @author apprentice
 */
public class Capital {

    private String name;
    private int pop;
    private float squareMile;
    
    // This is the default constructor
    public Capital() {
        
    }
    // this is an overloaded constructor  that passes multiple variables
    public Capital(String name, int pop, float squareMile) {
        this.name = name;
        this.pop = pop;
        this.squareMile = squareMile;

    }
    // Used encapsulation within NetBeans for Setters and Getters for all variables

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public double getSquareMile() {
        return squareMile;
    }

    public void setSquareMile(float squareMile) {
        this.squareMile = squareMile;
    }

}
