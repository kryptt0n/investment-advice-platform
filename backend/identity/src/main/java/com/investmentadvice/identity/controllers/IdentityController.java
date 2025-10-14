package com.investmentadvice.identity.controllers;

import com.investmentadvice.identity.dto.CredentialDTO;
import com.investmentadvice.identity.services.IdentityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identity")
public class IdentityController {

    private IdentityService identityService;

    public IdentityController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody CredentialDTO credentialDTO) {
        identityService.login(credentialDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody CredentialDTO credentialDTO) {
        identityService.register(credentialDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
