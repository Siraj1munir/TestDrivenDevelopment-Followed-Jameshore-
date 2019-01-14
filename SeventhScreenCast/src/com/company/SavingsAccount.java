package com.company;

public class SavingsAccount {
    private int startingBalance = 0;
    private int capitalGainsAmount = 0;
    private int interestRate = 0;
    private int totalWithdrawn = 0;
    private int startingPrincipal;

    public SavingsAccount() {
    }

    public SavingsAccount(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccount(int startingBalance, int startingPrincipal, int interestRate) {
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.capitalGainsAmount = startingBalance - startingPrincipal;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal() {
        return startingBalance - capitalGainsAmount;
    }

    public int interestRate() {
        return interestRate;
    }

    public int totalWithdrawn() {
        return totalWithdrawn;
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdrawn();
        return Math.max(0, result);
    }

    public int endingBalance(int capitalGainsTaxRate) {
        int modifiedStart = startingBalance - totalWithdrawn() - capitalGainsTaxIncurred(capitalGainsTaxRate);
        return modifiedStart + (modifiedStart * interestRate / 100);
    }

    public SavingsAccount nextYear(int capitalGainsTaxRate) {
        return new SavingsAccount(this.endingBalance(capitalGainsTaxRate), interestRate);
    }

    public void withdraw(int amount) {
        this.totalWithdrawn += amount;
    }

    public int capitalGainsWithdrawn() {
        int result =  -1 * (startingPrincipal() - totalWithdrawn());
        return Math.max(0, result);
    }

    public int capitalGainsTaxIncurred(int taxRate) {
        double dblTaxRate = taxRate/100.0;
        double dblCapGains = capitalGainsWithdrawn();
        return (int)((dblCapGains/(1-dblTaxRate)) - dblCapGains);
    }

}