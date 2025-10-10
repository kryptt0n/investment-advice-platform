package com.investmentadvice.token.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO {

    @NotBlank(message = "Token cant be blank")
    private String token;

    public TokenDTO() {}
}
