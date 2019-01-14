package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class savingAccountTest {

    @Test
    public void startingBalanceMatchesConstructor() {
        assertEquals(10000, newAccount().startingBalance());
    }
    @Test
    public void startingPrincipalMatchesConstructor() {
        SavingsAccount year = new SavingsAccount(10000, 3000, 10);
        assertEquals(3000, year.startingPrincipal());
    }
    @Test
    public void interestRateMatchesConstructor() {
        assertEquals(10, newAccount().interestRate());
    }

    @Test
    public void nextYearsStartingBalanceEqualsThisYearsEndingBalance() {
        SavingsAccount thisYear = newAccount();
        assertEquals(thisYear.endingBalance(25), thisYear.nextYear(25).startingBalance());
    }
    @Test
    public void startingCapitalGainsIsStartingBalanceMinusStartingPrincipal(){
        SavingsAccount year = new SavingsAccount(10000,3000,10);
        assertEquals(7000,year.startingCapitalGains());
    }
    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccount thisYear = newAccount();
        assertEquals(thisYear.interestRate(), thisYear.nextYear(25).interestRate());
    }

    @Test
    public void withdrawnFundsDoNotEarnInterest() {
        SavingsAccount year = newAccount();
        year.withdraw(1000);
        assertEquals(9900, year.endingBalance(25));
    }

    @Test
    public void multipleWithdrawalsInAYearAreTotaled(){
        SavingsAccount year = new SavingsAccount(10000,0, 10);
        year.withdraw(1000);
        year.withdraw(2000);
        assertEquals(3000, year.totalWithdrawn());
    }

    @Test
    public void endingPrincipalConsidersWithdrawals() {
        SavingsAccount year = new SavingsAccount(10000, 3000, 10);
        year.withdraw(2000);
        assertEquals("Ending Principal", 1000, year.endingPrincipal());
    }

    @Test
    public void endingPrincipalNeverGoesBelowZero() {
        SavingsAccount year = new SavingsAccount(10000, 3000, 10);
        year.withdraw(4000);
        assertEquals("Ending Principal", 0, year.endingPrincipal());
    }

    @Test
    public void withdrawing_More_Than_Principal_Take_From_CapitalGains() {
        SavingsAccount year = new SavingsAccount(10000, 3000, 10);
        year.withdraw(1000);
        assertEquals(0, year.capitalGainsWithdrawn());
        year.withdraw(3000);
        assertEquals(1000, year.capitalGainsWithdrawn());

    }

    @Test
    public void capitalGainsTaxIncurred_NeedToCoverYourCapitalGainsWithdrawn_AND_theAdditionalCapitalWidthDrawntoPay() {
        SavingsAccount year = new SavingsAccount(10000, 3000, 10);
        year.withdraw(5000);
        assertEquals(2000, year.capitalGainsWithdrawn());
        assertEquals(666, year.capitalGainsTaxIncurred(25));
    }

    @Test
    public void capitalGainsTaxIsIncludedInEndingBalance() {
        SavingsAccount year = new SavingsAccount(10000, 3000, 10);
        int amountWithdrawn = 5000;
        int expectedCapitalGainTax = 666;
        year.withdraw(amountWithdrawn);
        assertEquals(666, year.capitalGainsTaxIncurred(25));
        int expectedStartingBalanceAfterWithdrawals = 10000 - amountWithdrawn - expectedCapitalGainTax;
        assertEquals((int)(expectedStartingBalanceAfterWithdrawals * 1.10), year.endingBalance(25));
    }
    @Test
    public void endingPrincipalWithdrawals(){
        SavingsAccount year = new SavingsAccount(10000,3000,10);
        year.withdraw(2000);
        assertEquals(1000,year.endingPrincipal());
    }
    @Test
    public void endingCapitalGainsIncludesInterestEarned(){
        SavingsAccount year = new SavingsAccount(10000,3000,10);
        assertEquals(7000,year.startingCapitalGains());
        // This would fail screencast ended up here
        assertEquals(4000,year.endingCapitalGains());
    }

    @Test
    public void endingBalanceAppliesInterestRate(){
        assertEquals(11000,newAccount().endingBalance(25));
    }
    private SavingsAccount newAccount() {
        SavingsAccount account = new SavingsAccount(10000, 10000,10);
        return account;
    }

}
