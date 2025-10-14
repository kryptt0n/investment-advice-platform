package com.investmentadvice.token.repositories;

import com.investmentadvice.token.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
    Token findByUserId(UUID userId);
    void deleteByExpiresAtBefore(Date now);
    List<Token> findTokenByExpiresAtBefore(Date now);
}