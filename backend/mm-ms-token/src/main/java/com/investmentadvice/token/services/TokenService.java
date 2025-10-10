package com.investmentadvice.token.services;

import com.investmentadvice.token.dto.CredentialDTO;
import com.investmentadvice.token.dto.TokenDTO;
import com.investmentadvice.token.entities.Token;
import com.investmentadvice.token.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    private final TokenRepository repository;

    @Autowired
    public TokenService(TokenRepository repository) {
        this.repository = repository;
    }

    public void generateToken(CredentialDTO DTO) {
        UUID userId = DTO.getUserId();
        Token exsiting_token = repository.findByUserId(userId);
        if (exsiting_token != null) {
            repository.delete(exsiting_token);
        }
        // TODO: Generate token and store in database

    }

    public void verifyToken(TokenDTO DTO) {
        String token = DTO.getToken();
        Token tokenEntity = repository.findByToken(token);
        if (tokenEntity == null) {
            // Throw exception or return error message
        }
        // TODO: Verify token expiration and other details

    }

}
