/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.model;

/**
 *
 * @author apprentice
 */
public class StateContactCount {
    private String state;
    private int numContacts;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumContacts() {
        return numContacts;
    }

    public void setNumContacts(int numContacts) {
        this.numContacts = numContacts;
    }
    
}
