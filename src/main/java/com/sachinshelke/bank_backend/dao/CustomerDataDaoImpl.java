package com.sachinshelke.bank_backend.dao;

import com.sachinshelke.bank_backend.entity.CustomerData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDataDaoImpl implements CustomerDataDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDataDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CustomerData addNewCustomer(CustomerData newCustomerData) {
        newCustomerData.setId(0);
        CustomerData customerData = this.entityManager.merge(newCustomerData);
        return customerData;
    }

    @Override
    public List<CustomerData> getAllCustomerData() {
        TypedQuery<CustomerData> theQuery = this.entityManager.createQuery("from CustomerData", CustomerData.class);
        return theQuery.getResultList();
    }

    @Override
    public CustomerData getCustomerDataById(int id) {
        CustomerData customerData = getCustomerData(id);
        return customerData;
    }

    @Override
    public CustomerData updateCustomerData(CustomerData newCustomerData) {
        CustomerData customerData = this.entityManager.merge(newCustomerData);
        return customerData;
    }

    @Override
    public CustomerData updateBalance(int id, int balance) {
        CustomerData customerData = getCustomerData(id);
        customerData.setBalance(balance);
        updateCustomerData(customerData);
        return customerData;
    }

    @Override
    public CustomerData upateCustomerStatus(int id, boolean status) {
        CustomerData customerData = getCustomerData(id);
        customerData.setCustomerActive(status);
        return customerData;
    }

    @Override
    public void deleteCustomer(int id) {
        CustomerData customerData = getCustomerData(id);
        this.entityManager.remove(customerData);
    }

    private CustomerData getCustomerData(int id) {
        return this.entityManager.find(CustomerData.class, id);
    }
}
