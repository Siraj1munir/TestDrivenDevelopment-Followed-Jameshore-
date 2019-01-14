package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StockMarketYearTest {
    private static final int INTEREST_RATE = 10;
    private static final int STARTING_PRINCIPAL = 3000;
    private static final int STARTING_BALANCE = 10000;
    private static final int CAPITAL_GAINS_TAX_RATE = 25;

    @Test
    public void startingValues() {
        StockMarketYear year = newYear();
        assertEquals("Starting balance", Starting_BALANCE, year.startingBalance());
        assertEquals("Starting principal", STARTING_PRINCIPAL, year.startingPrincipal());
        assertEquals("Interest rate", INTEREST_RATE, year.interestRate());
        assertEquals("Capital gains tax rate", CAPITAL_GAINS_TAX_RATE, year.capitalGainsTaxRate());
        assertEquals("Total withdrawn default", 0, year.totalWithdrawn());
    }

    @Test
    public void capitalGainsTax() {
        StockMarketYear year = newYear();
        year.withdraw(4000);
        assertEquals("Capital gains tax includes tax on withdrawals to cover capital gains", 333, year.capitalGainsTaxIncurred());
        assertEquals("Total withdrawn includes capital gains tax", 4333, year.totalWithdrawn());
    }

    @Test
    public void interestEarned() {
        StockMarketYear year = newYear();
        assertEquals("Basic interest earned", 1000, year.interestEarned());
        year.withdraw(2000);
        assertEquals("Withdrawals don't earn interest", 800, year.interestEarned());
        year.withdraw(2000);
        assertEquals("Capital gains tax withdrawals don't earn interest", 566, year.interestEarned());
    }

    @Test
    public void endingPrincipal() {
        StockMarketYear year = newYear();
        year.withdraw(1000);
        assertEquals("Ending principal considers withdrawals", 2000, year.endingPrincipal());
        year.withdraw(500);
        assertEquals("Ending principal considers totals multiple withdrawals", 1500, year.endingPrincipal());
        year.withdraw(3000);
        assertEquals("Ending principal never goes below zero", 0, year.endingPrincipal());
    }

    @Test
    public void endingBalance() {
        StockMarketYear year = newYear();
        assertEquals("Ending balance includes interest", 11000, year.endingBalance());
        year.withdraw(1000);
        assertEquals("Ending balance includes withdrawals", 9900, year.endingBalance());
        year.withdraw(3000);
        assertEquals("Ending balance includes capital gains tax withdrawals", 6233, year.endingBalance());
    }

    @Test
    public void nextYearStartingValuesMatchesThisYearEndingValues() {
        StockMarketYear thisYear = newYear();
        StockMarketYear nextYear = thisYear.nextYear();
        assertEquals("Starting balance", thisYear.endingBalance(), nextYear.startingBalance());
        assertEquals("Starting principal", thisYear.endingPrincipal(), nextYear.startingPrincipal());
        assertEquals("Interest", thisYear.interestRate(), nextYear.interestRate());
        assertEquals("Capital gains tax rate", thisYear.capitalGainsTaxRate(), nextYear.capitalGainsTaxRate());
    }

    private StockMarketYear newYear() {
        return new StockMarketYear(STARTING_BALANCE, STARTING_PRINCIPAL, INTEREST_RATE, CAPITAL_GAINS_TAX_RATE);
    }
}
