package com.investmentadvice.identity.services;

import com.investmentadvice.identity.dto.CredentialDTO;
import com.investmentadvice.identity.feign.CredentialClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IdentityService {

    private CredentialClient credentialClient;

    public IdentityService(CredentialClient credentialClient) {
        this.credentialClient = credentialClient;
    }

    public void login(CredentialDTO credentialDTO) {
        credentialClient.login(credentialDTO);
        log.warn("Hit login at Identity Service with email {}", credentialDTO.getEmail());
    }

    public void register(CredentialDTO credentialDTO) {
        credentialClient.register(credentialDTO);
        log.warn("Hit register at Identity Service with email {}", credentialDTO.getEmail());
    }
}
