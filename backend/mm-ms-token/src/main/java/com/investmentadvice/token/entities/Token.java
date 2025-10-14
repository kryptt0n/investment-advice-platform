package com.investmentadvice.token.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Token")
public class Token {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private UUID tokenId;

    @Column(name = "user_id",nullable = false,unique = true)
    private UUID userId;

    @Column(name = "token",nullable = false,unique = true)
    private String token;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "expires_at")
    private Date expiresAt;

    public Token() {}

    public Token(UUID user_id,String token, Date createdAt, Date expiresAt) {
        this.userId = user_id;
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }
}
