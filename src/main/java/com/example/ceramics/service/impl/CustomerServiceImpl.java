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

    public void save(CustomerDTO customerDTO) {
        if (!customerRepository.existsByEmail(customerDTO.getEmail())) {
            Customer customer = Customer.builder()
                    .phone(customerDTO.getPhone())
                    .name(customerDTO.getName())
                    .email(customerDTO.getEmail())
                    .build();

            customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer with this name already exists, try with another one.");
        }
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer update(Long id, CustomerDTO request) {
        Customer customer = this.findById(id);
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());

        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    //create
    //review
    //update
    //delete
}
