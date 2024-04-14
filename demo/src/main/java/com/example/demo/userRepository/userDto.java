package com.example.demo.userRepository;

import jakarta.validation.constraints.NotBlank;
import org.w3c.dom.Text;

public record userDto(
        Long id,
        @NotBlank String first_name,
        @NotBlank String last_name,
        @NotBlank String email,
        @NotBlank String number,
        @NotBlank String password) {
}
