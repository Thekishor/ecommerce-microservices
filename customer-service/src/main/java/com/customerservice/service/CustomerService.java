package com.customerservice.service;

import com.customerservice.dto.CustomerRequest;
import com.customerservice.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    void createCustomer(CustomerRequest customerRequest);

    CustomerResponse getCustomerById(String id);

    List<CustomerResponse> getAllCustomers();

    void deleteCustomer(String id);

    void updateCustomer(String id, CustomerRequest customerRequest);

}