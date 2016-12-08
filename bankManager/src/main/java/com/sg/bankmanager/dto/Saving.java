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
public class Saving extends Accounts {

    public Saving(float balance, float balanceAvailable) {
        super(balance, balanceAvailable);
    }
    public Saving(){
        
    }
    @Override
    protected void withdraw(int request, boolean isOverdraft){
        //when you take money from savings, there is always a $10 service fee applied
        if(request>0){
        request += SERVICE_FEE;
        }
        //need to change both balances just in case there was a LARGE_DEPOSIT 
        //making it so that the 2 balance values differ
        setBalance(getBalance() - request);
        setBalanceAvailable(getBalanceAvailable() - request);
    }
    public void withdrawSavings(int request){
        withdraw(request, false);
    }
    public void depositSavings(int request){
        deposit(request);
    }
}
