package com.company;

import java.util.Scanner;

public class BankApplication{
    public static void main(String[] args) {
        BankAccount bank = new BankAccount("Chomneau", "C132435");
        bank.showMenu();
    }
}

class BankAccount {
    int previousTransaction;
    int balance;
    String customerName;
    String customerId;

    //constructor
    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    //widraw method
    void withdraw(int amount )
    {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    //deposit
    void deposit(int amount){
        if(amount != 0)
        {
            balance = balance+amount;
            previousTransaction = amount;
        }
    }

    //get transaction
    void getPreviousTransaction()
    {
        if (previousTransaction > 0) {
            System.out.println("Deposited " +previousTransaction);
        }else if(previousTransaction < 0) {
            System.out.println("withdrawn " + Math.abs(previousTransaction));
        }else {
            System.out.println("No transaction happened");
        }
    }

    //show menu

    void showMenu()
    {
        char option ='\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome" + customerName);
        System.out.println("Your ID is " +customerId);
        System.out.println("\n");

        System.out.println("A : Check balance");
        System.out.println("B : Deposit");
        System.out.println("C : Withdraw");
        System.out.println("D : Check previous transaction");
        System.out.println("E : Exit");
        do {
            System.out.println("*******************************");
            System.out.println("Enter the option");
            System.out.println("================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    System.out.println("--------------------------");
                    System.out.println("your balance is " + balance);
                    System.out.println("--------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("---------------------------");
                    System.out.println("Enter amount to deposit");
                    int depositAmount = scanner.nextInt();
                    System.out.println("---------------------------");
                    deposit(depositAmount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("---------------------------");
                    System.out.println("Enter amount to withdraw");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("---------------------------");
                    getPreviousTransaction();
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("****************************");
                    break;
                default:
                    System.out.println("Invalid option! please enter again!");
                    break;
            }
        }while (option != 'E');
                System.out.println("Thank you for using our ATM services");
    }
}
