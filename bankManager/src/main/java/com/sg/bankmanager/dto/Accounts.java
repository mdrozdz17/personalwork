/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.dto;

/**
 *
 * @author apprentice
 */
public abstract class Accounts {

    protected float balance;
    protected float balanceAvailable;
    protected static final int LARGE_DEPOSIT = 10000;
    protected static final int SERVICE_FEE = 10;
    protected static final String PIN = "1234";

    //abstract methods are not defined in this class, they MUST have the @Override in the inheriting class
    // then, define the method in the inheriting class, and have the EXACT SAME method signature
    // abstract methods are not allowed to have a body
    protected abstract void withdraw(int request, boolean isOverDraft);

    //this is the same for both inheriting classes, so it does not need to be definied in each individual class
    //it can be called as if it were defined in the inheriting class itself
    protected void deposit(int request) {
        setBalance(getBalance() + request);
        if (request < LARGE_DEPOSIT) {
            setBalanceAvailable(getBalanceAvailable() + request);
        }
    }
    //this constructor should be used only when the file is read, on the initial account creation
    // the setters are not used anywhere else, we don't want just anything able to set the account balance 
    public Accounts(float balance, float balanceAvailable){
        setBalance(balance);
        setBalanceAvailable(balanceAvailable);
    }
    public Accounts(){
        
    }

    public float getBalance() {
        return balance;
    }

    protected void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalanceAvailable() {
        return balanceAvailable;
    }

    protected void setBalanceAvailable(float balanceAvailable) {
        this.balanceAvailable = balanceAvailable;
    }
    
    public int getSERVICE_FEE(){
        return SERVICE_FEE;
    }
    public int getLARGE_DEPOSIT(){
        return LARGE_DEPOSIT;
    }
    public String getPIN(){
        return PIN;
    }
}
