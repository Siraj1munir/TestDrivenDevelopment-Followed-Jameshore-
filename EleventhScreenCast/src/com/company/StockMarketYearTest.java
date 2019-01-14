package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockMarketYearTest {

    @Test
    public void startingValues() {
        StockMarketYear year = newAccount();
        assertEquals("Starting Balance", 10000, year.startingBalance());
        assertEquals("Starting Principal", 3000, year.startingPrincipal());
        assertEquals("Interest Rate", 10, year.interestRate());
        assertEquals("Total Withdrawn Default", 0, year.totalWithdrawn(25));
    }

    @Test
    public void interestEarned() {
        StockMarketYear year = newAccount();
        assertEquals("Basic Interest Earned", 1000, year.interestEarned(25));
        year.withdraw(2000);
        assertEquals("Withdrawals Don't Earn Interest", 800, year.interestEarned(25));
    }
    @Test
    public void interestEarnedIsStartingBalanceCombinedWithInterestRate() {
        StockMarketYear year = new StockMarketYear(10000, 3000, 10);
        assertEquals(1000, year.interestEarned(25));
    }

    @Test
    public void endingPrincipal() {
        StockMarketYear year = newAccount();
        year.withdraw(1000);
        assertEquals("Ending Principal Considers Withdrawals", 2000, year.endingPrincipal());
        year.withdraw(500);
        assertEquals("Ending Principal Considers Totals Multiple Withdrawals", 1500, year.endingPrincipal());
        year.withdraw(3000);
        assertEquals("Ending Principal Never Goes Below Zero", 0, year.endingPrincipal());
    }

    @Test
    public void endingBalance() {
        StockMarketYear year = newAccount();
        assertEquals("Ending balance includes interest", 11000, year.endingBalance(25));
        year.withdraw(1000);
        assertEquals("ending balance includes withdrawals", 9900, year.endingBalance(25));
        year.withdraw(3000);
        assertEquals("ending balance includes capital gains tax withdrawals", 6233, year.endingBalance(25));
    }

    @Test
    public void withdrawnFundsDoNotEarnInterest() {
        StockMarketYear year = newAccount();
        year.withdraw(1000);
        assertEquals(900, year.interestEarned(25));
    }

    @Test
    public void totalWithdrawnIncludingCapitalGains() {
        StockMarketYear year = new StockMarketYear(10000, 0, 10);
        year.withdraw(1000);
        assertEquals("capital gains tax", 333, year.capitalGainsTaxIncurred(25));
        assertEquals("total withdrawn", 1333, year.totalWithdrawn(25));
    }

    @Test
    public void capitalGainsTaxesDoNotEarnInterest() {
        StockMarketYear year = new StockMarketYear(10000, 0, 10);
        year.withdraw(1000);
        assertEquals("capital gains withdrawn", 1000, year.capitalGainsWithdrawn());
        assertEquals("capital gains tax", 333, year.capitalGainsTaxIncurred(25));
        assertEquals("total withdrawn", 1333, year.totalWithdrawn(25));
        assertEquals("interest earned", 866, year.interestEarned(25));
    }

    @Test
    public void endingBalanceAppliesInterestRate() {
        assertEquals(11000, newAccount().endingBalance(25));
    }
    private StockMarketYear newAccount() {
        return new StockMarketYear(10000, 3000, 10);
    }

}