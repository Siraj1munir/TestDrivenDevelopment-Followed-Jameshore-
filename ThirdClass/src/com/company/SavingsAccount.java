package com.company;

public class SavingsAccount {

    private int balance = 0;
    private int interest = 0;
    private int capitalGainAmount = 0;
    private int totalWidthDrawn = 0;

    public SavingsAccount(){
    }
    public SavingsAccount(int startingBalance, int interest) {
        this.balance = startingBalance;
        this.interest = interest;
    }
    // our stuff
    public SavingsAccount(int startingBalance, int capitalGainAmount, int interest) {
        this.balance = startingBalance;
        this.capitalGainAmount = capitalGainAmount;
        this.interest = interest;
    }
    public void deposit(int amount){
        balance += amount;
    }
    public int balance(){
        return balance;
    }

    public void withdrawl(int amount) {
        balance -= amount;
        //this.totalWidthDrawn = amount;
    }
    public int startingPrincipal(){
        return startingBalance() - capitalGainAmount;
    }
    public int endingPrincipal() {
        int result = startingPrincipal() - totalWidthDrawn;
        return (result < 0) ? 0:result;
    }
    
    public SavingsAccount nextYear(int interest){
        SavingsAccount result = new SavingsAccount();
        result.deposit(balance()+(balance()*interest/100));
        return result;
    }
    public int startingBalance()
    {
        return balance;
    }
    public int endingBalance() {
        int modifiedStart = startingBalance() - totalWidthDrawn;
        return balance() + modifiedStart*interest/100;
    }
    public int interest(){
        return interest;
    }
    public SavingsAccount nextYear(){
        return new SavingsAccount(this.endingBalance(),interest);
    }


}