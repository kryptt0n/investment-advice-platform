package com.investmentadvice.token.controllers;

import com.investmentadvice.token.dto.CredentialDTO;
import com.investmentadvice.token.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate-token")
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<Void> generateToken(@Valid @RequestBody CredentialDTO credentialDTO) {
        tokenService.generateToken(credentialDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
