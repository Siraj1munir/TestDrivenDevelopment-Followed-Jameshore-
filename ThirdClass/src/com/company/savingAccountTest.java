package com.company;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class savingAccountTest {

    @Test
    public void endingBalance(){
        assertEquals("Ending Balance", 11000, newAccount().endingBalance());
    }
    @Test
    public void nextYearBalanceEqualThisYearEndingBalnce(){
        assertEquals(newAccount().endingBalance(),newAccount().nextYear().startingBalance());
    }
    @Test
    public void nextYearInterestEqualsThisYearInterestRate(){
        assertEquals(newAccount().interest(),newAccount().nextYear().interest());
    }
    @Test
    public void startingBalance(){
        assertEquals("Starting Balance", 10000,newAccount().startingBalance());
    }
    // Here Starts fourth screencast stuff
    @Test
    public void interestRate(){
        assertEquals("check interest rate",10,newAccount().interest());
    }

    @Test
    public void widthdrawingFundsOccurAtBeginningOfTheYear(){
        SavingsAccount year = newAccount();
        year.withdrawl(1000);
        assertEquals("TestWithStartingFunds",9900,year.endingBalance());
    }

//    @Test
//    public void withdrawingFundsMoreThanPrincipal(){
//        SavingsAccount year = new SavingsAccount(10000,7000,10);
//        year.withdrawl(3000);
//        assertEquals("GainTax",7700,year.endingBalance());
//        year.withdrawl(5000);
//        assertEquals(2000 + 200 - (1250),1250);
//    }
    @Test
    public void startingPrincipal(){
    SavingsAccount year = new SavingsAccount(10000,7000,10);
    assertEquals(3000,year.startingPrincipal());
    }
    @Test
    public void endingPrincipal(){
        SavingsAccount year = new SavingsAccount(10000,7000,10);
        assertEquals(3000,year.startingPrincipal());
        year.withdrawl(2000);
        assertEquals("ending principal", 1000,year.endingPrincipal());
    }
    @Test
    public void endingPrincipalBelowZero(){
        SavingsAccount year = new SavingsAccount(10000,7000,10);
        assertEquals(3000,year.startingPrincipal());
        year.withdrawl(4000);
        assertEquals("ending principal", 0,year.endingPrincipal());
    }
    // Helper Method

    private SavingsAccount newAccount(){
        SavingsAccount account = new SavingsAccount(10000,10);
        return account;
    }
}
