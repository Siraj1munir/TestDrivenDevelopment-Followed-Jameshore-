package com.company;

public class SavingsAccount {

    private int balance = 0;
    private int interest = 0;
    public SavingsAccount(){

    }
    public SavingsAccount(int startingBalance, int interest) {
        this.balance = startingBalance;
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
    }

    public SavingsAccount nextYear(int interest){
        SavingsAccount result = new SavingsAccount();
        result.deposit(balance()+(balance()*interest/100));
        return result;
    }
//    public SavingsAccount nextYear(){
//        SavingsAccount result = new SavingsAccount();
//        result.deposit(balance()+(balance()*interest/100));
//        return result;
//    }


    public int endingBalance() {

        return balance() + balance()*interest/100;
    }

    public int startingBalance() {
        return balance;
    }

    public SavingsAccount nextYear(){
        return new SavingsAccount(this.endingBalance(),interest);
    }
    public int interest(){
        return interest;
    }
}