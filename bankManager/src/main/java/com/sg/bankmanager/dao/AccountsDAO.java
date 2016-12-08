/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.dao;

import com.sg.bankmanager.dto.Accounts;
import com.sg.bankmanager.dto.Checking;
import com.sg.bankmanager.dto.Saving;
import com.sg.bankmanager.ui.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class AccountsDAO {

    public static final String ACCOUNT_FILE = "accounts.txt";
    public static final String DELIMITER = "::";
    private ConsoleIO con = new ConsoleIO();

    private HashMap<String, Accounts> accounts = new HashMap();

    public void saveData() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ACCOUNT_FILE));
        // Setting HashMap to Account to represent Checking and Savings
        Set<String> keySet = accounts.keySet();
        // Setting accountType to the keySet.
        for (String accountType : keySet) {
            out.print((accountType));
            out.print(DELIMITER);

            out.print((accounts.get(accountType)).getBalance());
            out.print(DELIMITER);

            out.print((accounts.get(accountType)).getBalanceAvailable());
            out.println("");

            out.flush();

        }

        out.close();

    }

    public void loadData() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ACCOUNT_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            switch (currentTokens[0]) {
                case "checking":
                    // Set balance to currentTokens[1] and balanceAvailable to currentTokens[2]
                    Checking check = new Checking(Float.parseFloat((currentTokens[1])), Float.parseFloat((currentTokens[2])));
                    accounts.put(currentTokens[0], check);
                    break;
                case "saving":
                    Saving save = new Saving(Float.parseFloat((currentTokens[1])), Float.parseFloat((currentTokens[2])));
                    accounts.put(currentTokens[0], save);
                    break;
                default:
                    ConsoleIO.showMessage("Could not find bank account type");
                    break;
            }

        }

    }
    
    // HashMap used to get the accounts once the user selects if they want checking
    // or savings after they enter pin to login
    public HashMap<String, Accounts> getAccounts(){
        return accounts;
    }
    
    // This HashMap is used to update checking/savings information after user
    // finishes there backing transaction to update the accounts
    public void updateAccounts(HashMap<String, Accounts> accounts){
        this.accounts = accounts;
    }
}
