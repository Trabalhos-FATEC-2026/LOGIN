package github.fatec.com.spring.controller;

import github.fatec.com.entity.Auth;
import github.fatec.com.entity.Token;
import github.fatec.com.spring.security.TokenSecurity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenSecurity tokenSecurity;

    public AuthController(TokenSecurity tokenSecurity) {
        this.tokenSecurity = tokenSecurity;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Token login(@RequestBody Auth request) {
        return tokenSecurity.gerarToken(request);
    }

    
}