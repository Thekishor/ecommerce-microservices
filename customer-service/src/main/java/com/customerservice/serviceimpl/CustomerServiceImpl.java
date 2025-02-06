package com.customerservice.serviceimpl;

import com.customerservice.dto.CustomerRequest;
import com.customerservice.dto.CustomerResponse;
import com.customerservice.entity.Address;
import com.customerservice.entity.Customer;
import com.customerservice.exception.ResourceNotFoundException;
import com.customerservice.repository.CustomerRepository;
import com.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        Customer customerInfo = customerRepository.save(customer);
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","ID",id));
        return modelMapper.map(customer,CustomerResponse.class);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> modelMapper.map(customer, CustomerResponse.class)).toList();
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","ID",id));
        customerRepository.delete(customer);
    }

    @Override
    public void updateCustomer(String id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","ID",id));
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPassword(customerRequest.getPassword());
        if (customerRequest.getAddress() != null){
            Address address = customerRequest.getAddress();
            customer.setAddress(address);
        }
        customerRepository.save(customer);
    }
}
