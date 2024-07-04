package com.sachinshelke.bank_backend.dao;

import com.sachinshelke.bank_backend.entity.CustomerData;

import java.util.List;

public interface CustomerDataDAO {
    //Create
    CustomerData addNewCustomer(CustomerData newCustomerData);

    //Read
    List<CustomerData> getAllCustomerData();
    CustomerData getCustomerDataById(int id);

    //update
    CustomerData updateCustomerData(CustomerData customerData);
    CustomerData updateBalance(int id, int balance);
    CustomerData upateCustomerStatus(int id, boolean status);

    //delete
    void deleteCustomer(int id);
}
