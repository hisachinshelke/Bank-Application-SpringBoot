package com.sachinshelke.bank_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bank_customer")
public class CustomerData {

    @Column(name="customer_name")
    private String customerName;

    @Column(name="account_number")
    private int accountNumber;

    @Column(name="balance")
    private int balance;

    @Column(name="customer_active")
    private boolean customerActive;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public CustomerData() {
    }

    public CustomerData(String customerName, int accountNumber, int balance, boolean customerActive, int id) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerActive = customerActive;
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankCustomerData{" +
                "customerName='" + customerName + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", customerActive=" + customerActive +
                ", id=" + id +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isCustomerActive() {
        return customerActive;
    }

    public void setCustomerActive(boolean customerActive) {
        this.customerActive = customerActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
