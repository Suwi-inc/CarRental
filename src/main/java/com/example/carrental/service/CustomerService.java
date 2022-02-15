package com.example.carrental.service;

import com.example.carrental.entity.Customer;

import com.example.carrental.model.CustomerModel;


public interface CustomerService {

    Customer getCustomerById(Long id);

    Iterable<Customer> getCustomers();

    Customer addCustomer(CustomerModel customerModel);

    Customer updateCustomer(Customer customer);

    void deleteById(Long id);
}
