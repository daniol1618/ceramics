package com.example.ceramics.service;

import com.example.ceramics.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService extends ICrudService<CustomerDTO, Long> {

    List<CustomerDTO> getOrderedByAge();

    List<CustomerDTO> getOrderedByAgeDesc();
}