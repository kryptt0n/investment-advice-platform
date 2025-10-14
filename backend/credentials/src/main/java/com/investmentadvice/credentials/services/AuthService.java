package com.investmentadvice.credentials.services;

import com.investmentadvice.credentials.dto.CredentialDTO;
import com.investmentadvice.credentials.entities.Credential;
import com.investmentadvice.credentials.repositories.CredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class AuthService {

    private CredentialRepository repository;

    @Autowired
    public AuthService(CredentialRepository repository) {
        this.repository = repository;
    }

    public void register(CredentialDTO credentialDTO) {
        log.warn("Hit register at Auth Service with email {}", credentialDTO.getEmail());
        String email = credentialDTO.getEmail();
        if (email.isBlank()) {
            throw new RuntimeException("Email cannot be blank");
        }

        if (repository.existsByEmail(email)) {
            throw new RuntimeException("Email is already used");
        }

        Credential credential = new Credential();
        credential.setCreatedAt(new Date());
        credential.setEmail(email);

        repository.save(credential);
    }

    public void login(CredentialDTO credentialDTO) {
        log.warn("Hit login at Auth Service with email {}", credentialDTO.getEmail());
        String email = credentialDTO.getEmail();
        if (email.isBlank()) {
            throw new RuntimeException("Email cannot be blank");
        }

        if (repository.existsByEmail(email)) {
            // Send verification code
        }
    }
}
