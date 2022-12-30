package com.driver;

public class InsufficientBalance extends Exception{
    public InsufficientBalance(){
        super("Insufficient Balance");
    }
}
