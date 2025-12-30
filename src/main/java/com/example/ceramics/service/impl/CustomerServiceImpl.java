package com.example.ceramics.service.impl;

import com.example.ceramics.dto.CustomerDTO;
import com.example.ceramics.model.Customer;
import com.example.ceramics.repository.CustomerRepository;
import com.example.ceramics.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        if (!customerRepository.existsByEmail(customer.getEmail())) {
            return customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer with this name already exists, try with another one.");
        }
    }

    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    public Customer update(String id, CustomerDTO request) {
        Customer customer = this.findById(id);
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());

        return customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        if (!customerRepository.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("Customer to be deleted does not exist on database");
        } else {
            customerRepository.delete(customer);
        }
    }

    //create
    //review
    //update
    //delete
}
