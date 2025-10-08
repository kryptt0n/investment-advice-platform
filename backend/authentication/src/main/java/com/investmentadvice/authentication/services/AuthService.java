package com.investmentadvice.authentication.services;

import com.investmentadvice.authentication.dto.CredentialDTO;
import com.investmentadvice.authentication.entities.Credential;
import com.investmentadvice.authentication.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    private CredentialRepository repository;

    @Autowired
    public AuthService(CredentialRepository repository) {
        this.repository = repository;
    }

    public void register(CredentialDTO credentialDTO) {

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

        String email = credentialDTO.getEmail();
        if (email.isBlank()) {
            throw new RuntimeException("Email cannot be blank");
        }

        if (repository.existsByEmail(email)) {
            // Send verification code
        }
    }
}
