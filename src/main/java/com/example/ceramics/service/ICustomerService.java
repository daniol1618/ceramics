package com.example.ceramics.service;

import com.example.ceramics.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    CustomerDTO create(CustomerDTO request);

    CustomerDTO getById(Long id);

    List<CustomerDTO> getAll();

    CustomerDTO update(Long id, CustomerDTO request);

    void deleteById(Long id);


    List<CustomerDTO> getOrderedByAge();

    List<CustomerDTO> getOrderedByAgeDesc();
}