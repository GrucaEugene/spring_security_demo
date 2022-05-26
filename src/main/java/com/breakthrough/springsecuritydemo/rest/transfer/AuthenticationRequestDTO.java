package com.breakthrough.springsecuritydemo.rest.transfer;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}
