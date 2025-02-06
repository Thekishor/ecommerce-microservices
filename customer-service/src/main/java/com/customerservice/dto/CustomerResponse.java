package com.customerservice.dto;

import com.customerservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {

    private String customerId;
    private String name;
    private String email;
    private String password;
    private Address address;
}
