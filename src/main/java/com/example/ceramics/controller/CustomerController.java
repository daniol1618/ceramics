package com.example.ceramics.controller;

import com.example.ceramics.dto.CustomerDTO;
import com.example.ceramics.service.impl.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void save(@Valid @RequestBody CustomerDTO customerDTO) {
        customerService.create(customerDTO);
    }

    @GetMapping("/{id}")
    private CustomerDTO findById(@PathVariable Long id) {
        return customerService.getById(id);
    }


    @GetMapping
    private List<CustomerDTO> findAll() {
        return customerService.getAll();
    }

    @GetMapping("/sorted/comparable")
    private List<CustomerDTO> findOrderedByAge() {
        return customerService.getOrderedByAge();
    }

    @GetMapping("/sorted/comparator")
    private List<CustomerDTO> findOrderedByAgeDesc() {
        return customerService.getOrderedByAgeDesc();
    }

    @PutMapping("/{id}")
    private void update(
            @PathVariable Long id,
            @Valid @RequestBody CustomerDTO customerDTO
    ) {
        customerService.update(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}
