package com.example.ceramics.mapper;

import com.example.ceramics.dto.CustomerDTO;
import com.example.ceramics.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .age(dto.getAge())
                .build();
    }

    public CustomerDTO toDto(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .age(customer.getAge())
                .build();
    }
}
