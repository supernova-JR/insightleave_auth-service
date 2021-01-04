package com.insightleave.authservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSignUpDto {
    private String name;
    private String email;
    private String password;
    private String role;
    private String gender;
}
