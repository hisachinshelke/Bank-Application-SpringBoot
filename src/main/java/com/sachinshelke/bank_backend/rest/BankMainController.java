package com.sachinshelke.bank_backend.rest;

import com.sachinshelke.bank_backend.entity.CustomerData;
import com.sachinshelke.bank_backend.service.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-api")
public class BankMainController {

    private CustomerDataService customerDataService;

    @Autowired
    public BankMainController(CustomerDataService customerDataService) {
        this.customerDataService = customerDataService;
    }

    @GetMapping("/")
    public String wcMsg(){
        return "Welcome to Sachin Bank of India - SBI";
    }

    @GetMapping("/customerdata")
    public List<CustomerData> getAllCustomerData(){
        return this.customerDataService.getAllCustomerData();
    }

    @PostMapping("/customerdata")
    public CustomerData addNewCustomer(@RequestBody CustomerData newCustomerData){
        return this.customerDataService.addNewCustomer(newCustomerData);
    }

    @DeleteMapping("/customerdata/{id}")
    public void deleteCustomerById(@PathVariable int id){
        this.customerDataService.deleteCustomer(id);
    }
}
