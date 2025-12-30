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

    //c
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void save(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
    }

    //r
    @GetMapping("/{id}")
    private Customer findById(@PathVariable String id) {
        return customerService.findById(id);
    }

    //r
    @GetMapping("/{id}")
    private List<Customer> findAll(@PathVariable String id) {
        return customerService.findAll();
    }

    //u
    @PutMapping("/{id}")
    private void update(
            @PathVariable String id,
            @RequestBody CustomerDTO customerDTO
    ) {
        customerService.update(id, customerDTO);
    }

    //d
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable String id) {
        customerService.deleteById(id);
    }
}
