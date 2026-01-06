package com.example.ceramics.controller;

import com.example.ceramics.dto.CustomerDTO;
import com.example.ceramics.service.impl.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests the entire CustomerController (Web layer only)
 */
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerServiceImpl customerService;

    @Test
    void shouldSaveCustomer() throws Exception {
        CustomerDTO dto = CustomerDTO.builder()
                .name("John")
                .email("johntest@test.com")
                .phone("3216556565")
                .age(35)
                .build();

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnCustomerById() throws Exception {
        CustomerDTO dto = CustomerDTO.builder()
                .name("John")
                .email("johntest@test.com")
                .phone("3216556565")
                .age(34)
                .build();

        when(customerService.getById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.email").value("johntest@test.com"))
                .andExpect(jsonPath("$.age").value(34));
    }

    @Test
    void shouldReturnCustomers() throws Exception {
        CustomerDTO customer1 = CustomerDTO.builder()
                .name("John")
                .email("john@test.com")
                .phone("1111111111")
                .age(30)
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .name("Maria")
                .email("maria@test.com")
                .phone("2222222222")
                .age(25)
                .build();

        when(customerService.getAll()).thenReturn(List.of(customer1, customer2));

        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Maria"));
    }

    @Test
    void shouldReturnCustomersOrderedByAgeAsc() throws Exception {
        CustomerDTO younger = CustomerDTO.builder().name("Maria").age(25).build();
        CustomerDTO older = CustomerDTO.builder().name("John").age(30).build();

        when(customerService.getOrderedByAge()).thenReturn(List.of(younger, older));

        mockMvc.perform(get("/api/customers/sorted/comparable"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Maria"))
                .andExpect(jsonPath("$[1].name").value("John"));
    }

    @Test
    void shouldReturnCustomersOrderedByAgeDesc() throws Exception {
        CustomerDTO older = CustomerDTO.builder().name("John").age(30).build();
        CustomerDTO younger = CustomerDTO.builder().name("Maria").age(25).build();

        when(customerService.getOrderedByAgeDesc()).thenReturn(List.of(older, younger));

        mockMvc.perform(get("/api/customers/sorted/comparator"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Maria"));
    }

    @Test
    void shouldUpdateCustomer() throws Exception {
        CustomerDTO dto = CustomerDTO.builder()
                .name("Updated Name")
                .email("updated@test.com")
                .phone("9999999999")
                .age(40)
                .build();

        mockMvc.perform(put("/api/customers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteCustomerById() throws Exception {
        mockMvc.perform(delete("/api/customers/1"))
                .andExpect(status().isNoContent());
    }
}