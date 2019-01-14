package com.company;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class savingAccountTest {

    @Test
    public void deposit(){
        SavingsAccount account = new SavingsAccount();
        account.deposit(100);
        assertEquals("After Deposit", 100, account.balance());
        account.withdrawl(50);
        assertEquals("After Withdraw",50 , account.balance());
    }
    @Test
    public void negativeBalance(){
        SavingsAccount account = new SavingsAccount();
        account.withdrawl(75);
        assertEquals("negative balance",-75, account.balance());

    }

    @Test
    public void nextYear(){
        SavingsAccount account = new SavingsAccount();
        account.deposit(10000);
        SavingsAccount nextYear = account.nextYear(10);
        assertEquals("Next Year", 11000, nextYear.balance());
    }
    @Test
    public void endingBalance(){
        SavingsAccount account = new SavingsAccount(10000,10);
        assertEquals("Ending Balance", 11000, account.endingBalance());
    }
    @Test
    public void nextYearBalanceEqualThisYearEndingBalnce(){
        SavingsAccount account = new SavingsAccount(10000,10);
        assertEquals(account.endingBalance(),account.nextYear().startingBalance());
    }
    @Test
    public void nextYearInterestEqualsThisYearInterestRate(){
        SavingsAccount thisYear = new SavingsAccount(10000,10);
        assertEquals(thisYear.interest(),thisYear.nextYear().interest());
    }

}
