package com.example.ceramics.service.impl;

import com.example.ceramics.dto.CustomerDTO;
import com.example.ceramics.exception.CustomerAlreadyExistsException;
import com.example.ceramics.exception.CustomerNotFoundException;
import com.example.ceramics.mapper.CustomerMapper;
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
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO create(CustomerDTO request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new CustomerAlreadyExistsException(request.getEmail());
        }

        Customer customer = customerMapper.toEntity(request);
        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toDto(savedCustomer);
    }

    @Override
    public CustomerDTO getById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());

        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(updatedCustomer);
    }

    @Override
    public void deleteById(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
    }
}
