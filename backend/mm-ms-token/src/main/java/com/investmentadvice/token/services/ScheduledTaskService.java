package com.investmentadvice.token.services;

import com.investmentadvice.token.entities.Token;
import com.investmentadvice.token.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScheduledTaskService {
    private final TokenRepository tokenRepository;

    @Autowired
    public ScheduledTaskService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void cleanupExpiredTokens() {
            Date currentDate = new Date();
            List<Token> expiredTokens = tokenRepository.findTokenByExpiresAtBefore(currentDate);
            
            if (!expiredTokens.isEmpty()) {
                tokenRepository.deleteByExpiresAtBefore(currentDate);
            }
    }
}