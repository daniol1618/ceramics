package com.example.ceramics.controller;

import com.example.ceramics.dto.CustomerDTO;
import com.example.ceramics.model.Customer;
import com.example.ceramics.service.impl.CustomerServiceImpl;
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
    private void save(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
    }

    @GetMapping("/{id}")
    private Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    private List<Customer> findAll() {
        return customerService.findAll();
    }

    @PutMapping("/{id}")
    private void update(
            @PathVariable Long id,
            @RequestBody CustomerDTO customerDTO
    ) {
        customerService.update(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}
