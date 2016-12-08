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
public class Checking extends Accounts {

    public Checking(float balance, float balanceAvailable) {
        super(balance, balanceAvailable);
    }
    public Checking(){
        
    }
    @Override
    protected void withdraw(int request, boolean isOverDraft) {
        if (isOverDraft) {
            request += SERVICE_FEE;
        }
        setBalance(getBalance() - request);
        setBalanceAvailable(getBalanceAvailable() - request);
    }
    
    public void withdrawChecking(int request, boolean isOverDraft) {
        withdraw(request, isOverDraft);
    }
    
    public void depositChecking(int request){
        deposit(request);
    }
}
