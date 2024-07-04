package com.sachinshelke.bank_backend.service;

import com.sachinshelke.bank_backend.dao.CustomerDataDAO;
import com.sachinshelke.bank_backend.entity.CustomerData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDataServiceImpl implements CustomerDataService{

    private CustomerDataDAO customerDataDAO;

    @Autowired
    public CustomerDataServiceImpl(CustomerDataDAO customerDataDAO) {
        this.customerDataDAO = customerDataDAO;
    }

    @Override
    @Transactional
    public CustomerData addNewCustomer(CustomerData newCustomerData) {
        return customerDataDAO.addNewCustomer(newCustomerData);
    }

    @Override
    public List<CustomerData> getAllCustomerData() {
        return customerDataDAO.getAllCustomerData();
    }

    @Override
    public CustomerData getCustomerDataById(int id) {
        return customerDataDAO.getCustomerDataById(id);
    }

    @Override
    @Transactional
    public CustomerData updateCustomerData(CustomerData customerData) {
        return customerDataDAO.updateCustomerData(customerData);
    }

    @Override
    @Transactional
    public CustomerData updateBalance(int id, int balance) {
        return customerDataDAO.updateBalance(id, balance);
    }

    @Override
    @Transactional
    public CustomerData upateCustomerStatus(int id, boolean status) {
        return customerDataDAO.upateCustomerStatus(id, status);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDataDAO.deleteCustomer(id);
    }
}
