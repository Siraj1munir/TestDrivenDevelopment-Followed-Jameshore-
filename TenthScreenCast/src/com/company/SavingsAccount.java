package com.company;

public class SavingsAccount {
    private int startingBalance = 0;
    private int interestRate = 0;
    private int totalWithdrawals =0;
    private int startingPrincipal;

    public SavingsAccount(int startingBalance, int startingPrincipal, int interestRate){
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.interestRate = interestRate;
    }

    public int startingBalance(){
        return startingBalance;
    }

    public int startingPrincipal(){
        return startingPrincipal;
    }

    public int startingCapitalGains(){
        return startingBalance - startingPrincipal;
    }

    public int interestRate(){
        return interestRate;
    }

    public void withdraw(int amount){
        this.totalWithdrawals += amount;
    }

    public int endingPrincipal(){
        int result = startingPrincipal() - totalWithdrawals;
        return Math.max(0, result);
    }

    public int endingBalance(int capitalGainsTaxRate){
        int modifiedStart = startingBalance - totalWithdrawn(capitalGainsTaxRate);
        return modifiedStart + interestEarned(capitalGainsTaxRate);
    }

    public SavingsAccount nextYear(int capitalGainsTaxRate){
        return new SavingsAccount(this.endingBalance(capitalGainsTaxRate), 0, interestRate);
    }
    public int capitalGainsWithdrawn(){
        int result =  -1 * (startingPrincipal() - totalWithdrawals);
        return Math.max(0, result);
    }
    public int capitalGainsTaxIncurred(int taxRate){
        double dblTaxRate = taxRate / 100.0;
        double dblCapGains = capitalGainsWithdrawn();
        return (int)((dblCapGains / (1 - dblTaxRate)) - dblCapGains);
    }

    public int endingCapitalGains(int capitalGainsTaxRate) {
       return startingCapitalGains() - capitalGainsWithdrawn() + interestEarned(capitalGainsTaxRate);
    }

    public int interestEarned(int capitalGainsTaxRate) {
        return (startingBalance - totalWithdrawn(capitalGainsTaxRate)) * interestRate/100;
    }

    public int totalWithdrawn(int capitalGainsTaxRate) {
        return totalWithdrawals + capitalGainsTaxIncurred(capitalGainsTaxRate);
    }
}