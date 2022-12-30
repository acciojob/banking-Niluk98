package com.driver;

public class Main {
    public static void main(String[] args) {
      BankAccount b=new BankAccount("abc",1000,500);
      try{
          System.out.print(b.generateAccountNumber(3,0));
      }catch (Exception e){
          System.out.print("Error");
      }
    }
}