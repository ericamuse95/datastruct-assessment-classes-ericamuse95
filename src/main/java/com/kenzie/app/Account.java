package com.kenzie.app;
import java.util.Locale;
import java.util.Random;
public class Account {
    //create class instance variables here
    private String userName;
    private String accountID;
    private double balance;


    //implement the following class constructors
    public Account(String userName) {
        //if account ID is not passed in, generate accountID using username
        this.userName = userName;
        String firstThreeChars = "";
        if (userName.length() > 3)
        {
            firstThreeChars = userName.toLowerCase().substring(0,3);
        }
        else {
            firstThreeChars = userName.toLowerCase(Locale.ROOT);
        }
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        String idNumber =  String.format("%06d", number);
        this.accountID = firstThreeChars + idNumber;



    }

    public Account(String userName, String accountId) {
        this.userName = userName;
        this.accountID = accountId;

    }

    public Account(String userName, String accountId, double balance) {
        this.userName = userName;
        this.accountID = accountId;
        this.balance = balance;

    }

    public String getUserName() {
        // return the user name of the current account
        return userName;
    }

    public String getAccountId() {
        // return the account id fo the current account
        return accountID;
    }

    public double getBalance() {
        // return the current balance of the account
        //return 0.0;
        return balance;
    }

    public void makeDeposit(double amount) {
        // Add the given amount to the balance of the account
        this.balance = balance + amount;

    }

    public double makeWithdrawal(double amount) {
        // If the account has enough money, then withdraw the given amount
        // If the account does not have enough money, then return 0 and do not modify the balance
        // Otherwise return the amount that was withdrawn
        if (amount > balance){
            this.balance = balance;
            return 0.0;
        } else {
            this.balance = balance - amount;
            return amount;
        }
    }
}
