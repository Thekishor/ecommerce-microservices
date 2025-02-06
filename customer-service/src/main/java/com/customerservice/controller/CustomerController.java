package com.customerservice.controller;

import com.customerservice.dto.CustomerRequest;
import com.customerservice.dto.CustomerResponse;
import com.customerservice.payload.ApiResponse;
import com.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        customerService.createCustomer(customerRequest);
        return new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        List<CustomerResponse> customerResponses = customerService.getAllCustomers();
        return new ResponseEntity<>(customerResponses, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("customerId") String id){
        CustomerResponse customerResponse = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(new ApiResponse("Customer Deleted Successfully", true), HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> updateMapping(@PathVariable("customerId") String id, @Valid @RequestBody CustomerRequest customerRequest){
        customerService.updateCustomer(id,customerRequest);
        return new ResponseEntity<>(new ApiResponse("Customer record update successfully", true), HttpStatus.OK);
    }
}
