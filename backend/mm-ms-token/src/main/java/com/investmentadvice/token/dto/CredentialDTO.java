package com.investmentadvice.token.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class CredentialDTO {
    @NotBlank(message = "user id is required")
    private UUID userId;
}
