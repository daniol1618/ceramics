package com.example.ceramics.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "Email is invalid")
    private String email;

    @Pattern(
            regexp = "^[0-9+\\- ]+$",
            message = "phone is invalid"
    )
    private String phone;
}
