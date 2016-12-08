/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.bankmanager.dto.Accounts;
import com.sg.bankmanager.dto.Checking;
import com.sg.bankmanager.dto.Saving;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author apprentice
 */
public class TestAccountsChildren {
    
    public TestAccountsChildren() {
    }
    
    HashMap <String, Accounts> accounts;
    float delta;
    
    @Before
    public void initialize(){
        accounts = new HashMap<>();
        //making a new account is Accounts(balance, balanceAvailable)
        Checking checking = new Checking(0,0);
        Saving saving = new Saving(0,0);
        accounts.put("saving", saving);
        accounts.put("checking", checking);
        delta = (float) .009999;
    }
    
    @Test
    public void testGetBalances(){
        //Arrange
        //Act
        float actualChecking =accounts.get("checking").getBalance();
        float actualSaving =accounts.get("saving").getBalance();
        float availableChecking =accounts.get("checking").getBalanceAvailable();
        float availableSaving =accounts.get("saving").getBalanceAvailable();
        //Assert
        assertEquals(0,actualChecking,delta);
        assertEquals(0,actualSaving,delta);
        assertEquals(0,availableChecking,delta);
        assertEquals(0,availableSaving,delta);
    }
    
    @Test
    public void testDepositChecking(){
        //Arrange
        Checking checking = new Checking();
        checking = (Checking) accounts.get("checking");
        //Act
        checking.depositChecking(0);
        //Assert
        assertEquals(0, checking.getBalance(),delta);
        assertEquals(0, checking.getBalanceAvailable(),delta);
        //Act
        checking.depositChecking(10);
        //Assert
        assertEquals(10, checking.getBalance(),delta);
        assertEquals(10, checking.getBalanceAvailable(),delta);
        //Act
        checking.depositChecking(checking.getLARGE_DEPOSIT()*2);
        //Assert
        assertEquals(20010, checking.getBalance(),delta);
        assertEquals(10, checking.getBalanceAvailable(), delta);
    }
    
    @Test
    public void testWithdrawChecking(){
        //Arrange
        Checking checking = new Checking();
        checking = (Checking) accounts.get("checking");
        checking.depositChecking(500);
        float actual;
        //Act
        checking.withdrawChecking(0, false);
        actual = checking.getBalance();
        //Assert
        assertEquals(500,actual, delta);
        //Act
        checking.withdrawChecking(100, false);
        actual = checking.getBalance();
        //Assert
        assertEquals(400,actual, delta);
        //Act
        checking.withdrawChecking(450, false);
        actual = checking.getBalance();
        //Assert
        assertEquals(-50,actual, delta);
    }
    
    @Test
    public void testWithdrawSaving(){
        //Arrange
        Saving saving = new Saving();
        saving = (Saving) accounts.get("saving");
        saving.depositSavings(500);
        float actual;
        //Act
        saving.withdrawSavings(0);
        actual = saving.getBalance();
        //Assert
        assertEquals(500, actual, delta);
        //Act
        saving.withdrawSavings(1);
        actual = saving.getBalance();
        //Assert
        assertEquals(489, actual, delta);
    }
}
