package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.balance = balance;
        this.name = name;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        String accountNo =helper(digits,sum,"");

        if (accountNo.isEmpty()) {
            throw new AccountNumberExcpetion("Account Number can not be generated");
        }
        return accountNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        this.balance -= amount;
        if (balance < minBalance) {
            throw new InsufficientBalance();
        }
    }

    public String helper(int digits, int sum, String accNo) {
        if(sum==0 && digits==0){
            return accNo;
        }
        String ans="";
        if(digits>0 && sum>=0){
            int i=0;

            while(i<=9){
                String s=helper(digits-1,sum-i,accNo+i);
                if(!s.isEmpty()){
                    ans=s;
                }
                i++;
            }
        }
        return ans;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}