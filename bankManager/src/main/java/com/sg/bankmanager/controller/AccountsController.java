/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.controller;

import com.sg.bankmanager.dao.AccountsDAO;
import com.sg.bankmanager.dto.Accounts;
import com.sg.bankmanager.dto.Checking;
import com.sg.bankmanager.dto.Saving;
import com.sg.bankmanager.ui.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class AccountsController {

    /*
    Design a program which acts as an ATM machine. 
    The user can specify a PIN and it will show them a menu of their account types 
    (checking and savings). 
    Allow the user to deposit or withdraw money from a selected account type. 
    Be sure to check that they cannot withdraw more money than they have. 
    If the user deposits more than $10,000, the program should let the user know 
    that it has contacted the bank manager to clear the deposit and will not allow 
    them to withdraw any of that money. 
     */
    Saving save = new Saving();
    Checking check = new Checking();
    //use the account type to set the above account instances equal to the actual
    //objects from the DAO.  That is how we can get knowledge of the balances
    AccountsDAO myAccount = new AccountsDAO();
    HashMap<String, Accounts> accounts;

    public void run() {
        boolean keepGoing = true;
        String menuSelection;
        try {
            myAccount.loadData();
            login();
            while (keepGoing) {
                //display a menu
                displayMainMenu();
                menuSelection = ConsoleIO.promptString("Please select from the below choices").toLowerCase();

                switch (menuSelection) {
                    //allow the user to deposit or withdraw monew from a selected account
                    case "1":
                    case "withdraw":
                        ConsoleIO.showMessageln("Withdraw money from an account");
                        //get the account type
                        String account = getAccountType();
                        withdraw(account);
                        break;
                    //if the user deposits more than 10k,
                    //display message about that money not being part of the balanceAvailable
                    case "2":
                    case "deposit":
                        ConsoleIO.showMessageln("Deposit money into an account");
                        deposit();
                        break;
                    case "3":
                    case "check":
                        ConsoleIO.showMessageln("Check current balance in an account");
                        displayAccountBalance();
                        break;
                    case "4":
                    case "exit":
                        ConsoleIO.showMessageln("Exit ATM");
                        keepGoing = false;
                        break;
                    default:
                        ConsoleIO.showMessageln("Unknown Command");

                }
            }

            ConsoleIO.showMessageln("Thank you for using the Johnny Bravo ATM");
            //sends the updated hashmap back to the DAO
            myAccount.updateAccounts(accounts);
            //tells the DAO to save the account information to file
            myAccount.saveData();
        } catch (FileNotFoundException ex) {
            ConsoleIO.showMessageln("Error loading Accounts.");
        } catch (IOException ex) {
            ConsoleIO.showMessageln("Error saving bank transaction");

        }
    }

    //display the main menu to the user
    private void displayMainMenu() {
        ConsoleIO.showMessageln("Welcome to the main menu, please make a selection:\n"
                + "1. WITHDRAW money from an account.\n"
                + "2. DEPOSIT money into an account.\n"
                + "3. CHECK current balance in an account.\n"
                + "4. EXIT and logout.");
    }

    //method to login with a required PIN
    private void login() {
        while (true) {
            String userPIN = ConsoleIO.promptString("Please enter your PIN to login: ");
            if (userPIN.equals(check.getPIN()) || userPIN.equals(save.getPIN())) {
                ConsoleIO.showMessageln("Login Success!");
                accounts = myAccount.getAccounts();
                save = (Saving) accounts.get("saving");
                check = (Checking) accounts.get("checking");
                return;
            } else {
                // added a message back to user if pin is not correct.
                ConsoleIO.showMessageln("Incorrect pin. Please re-enter your pin");

            }
        }
    }

    //method to get a specific account type from the user choice
    private String getAccountType() {
        String accountType;
        while (true) {
            accountType = ConsoleIO.promptString("Account type? (checking/saving)").toLowerCase();
            //making the user tell us the account they are trying to access
            switch (accountType) {
                case "saving":
                case "checking":
                    return accountType;
                default:
                    ConsoleIO.showMessageln("Account type unknown.");
                    break;
            }
        }
    }

    //method to request amount to withdraw/deposit
    private int requestAmount(String prompt) {
        int request = ConsoleIO.promptIntPositive(prompt);
        return request;
    }

    //method to go through the withdraw process
    private void withdraw(String account) {

        //use the account type to set the above account instances equal to the actual
        //objects from the DAO.  That is how we can get knowledge of the balances
        //declare overDraft and tryagain
        boolean isOverDraft;
        boolean tryAgain;
        //do-while to make sure the withdraw goes smoothly
        do {
            //reset the booleans to false, they will turn true when needed later in the code
            isOverDraft = false;
            //tryAgain determines if the user srewed up and needs to try the withdraw process again
            tryAgain = false;
            int request = requestAmount("Enter the quantity to withdraw (0 returns to the main menu)");
            if (request == 0) {
                return;
            }
            if (account.equalsIgnoreCase("saving")) {
                if (request > save.getBalanceAvailable()) {
                    tryAgain = true;
                    ConsoleIO.showMessageln("You don't have that much money available...\n"
                            + "Try again.");
                } else {
                    save.withdrawSavings(request);

                    ConsoleIO.showMessageln("A service fee of $" + save.getSERVICE_FEE() + " will be applied to your withdraw");
                    ConsoleIO.showMessageln("Your new balance available is $" + save.getBalanceAvailable());

                }
            } else if (account.equalsIgnoreCase("checking")) {
                //create an overDraftValue to check if the request was an overdraft
                float overDraftValue = request - check.getBalanceAvailable();
                if (overDraftValue > 0) {
                    //the user tried to withdraw more than they had in their checking account
                    //it is an overdraft
                    isOverDraft = true;
                    if (overDraftValue > 100) {
                        //the user tried to take more than the ammount of overdraft protection
                        //please try again
                        tryAgain = true;
                        ConsoleIO.showMessageln("Your balance available is not that big...\n"
                                + "Overdraft protection does not allow you to take that much money...\n"
                                + "Try again.");
                    } else {
                        //overdrafting has a service fee
                        //notify user
                        check.withdrawChecking(request, isOverDraft);
                        ConsoleIO.showMessageln("A service fee of $" + check.getSERVICE_FEE() + " will be applied to your withdraw");
                        ConsoleIO.showMessageln("Your new balance available is $" + check.getBalanceAvailable());

                    }
                } else {
                    //here, we should be taking money out of checking safely
                    //no fees, still should have money remaining in the checking account
                    check.withdrawChecking(request, isOverDraft);
                }
            }
        } while (tryAgain);
    }

    //method to go through the deposit process
    private void deposit() {
        String account = getAccountType();
        int request = requestAmount("Enter the quantity to deposit");
        if (account.equalsIgnoreCase("checking")) {
            if (request > check.getLARGE_DEPOSIT()) {
                ConsoleIO.showMessageln("The bank manager has been contacted to clear "
                        + "the deposit, and will not let you withdraw any of that money");

            }
            //don't need an else statement because the money gets deposited no matter what.
            //the balance handling was done in the individual classes (DTOs)
            check.depositChecking(request);
            ConsoleIO.showMessageln("Your deposit of has successfully added to your account");
            ConsoleIO.showMessageln("Your new balance available is $" + check.getBalanceAvailable());

        } else if (account.equalsIgnoreCase("saving")) {
            if (request > save.getLARGE_DEPOSIT()) {
                ConsoleIO.showMessageln("The bank manager has been contacted to clear "
                        + "the deposit, and will not let you withdraw any of that money");

            }
            save.depositSavings(request);
            ConsoleIO.showMessageln("Your deposit of has successfully added to your account");
            ConsoleIO.showMessageln("Your new balance available is $" + save.getBalanceAvailable());

        }
    }

    //method to display an account balance
    private void displayAccountBalance() {
        while (true) {
            String account = getAccountType();
            switch (account) {
                //diaplay available balance
                //display actual balance, only if different from available balance
                case "saving":
                    ConsoleIO.showMessageln("Balance available: " + save.getBalanceAvailable());
                    if (save.getBalanceAvailable() != save.getBalance()) {
                        ConsoleIO.showMessageln("Actual balance: " + save.getBalance());
                    }
                    return;
                case "checking":
                    ConsoleIO.showMessageln("Balance available: " + check.getBalanceAvailable());
                    if (check.getBalanceAvailable() != check.getBalance()) {
                        ConsoleIO.showMessageln("Actual balance: " + check.getBalance());
                    }
                    return;
                default:
                    break;
            }
        }
    }
}
