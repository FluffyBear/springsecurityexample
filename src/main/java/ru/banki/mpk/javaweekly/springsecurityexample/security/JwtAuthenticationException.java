package ru.banki.mpk.javaweekly.springsecurityexample.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

import java.io.Serial;

@Getter
public class JwtAuthenticationException extends AuthenticationException {

    @Serial
    private static final long serialVersionUID = -6819646983175436237L;

    private HttpStatus httpStatus;

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
    public JwtAuthenticationException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

}
