package ru.banki.mpk.javaweekly.springsecurityexample.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String email;

    private String password;

}
