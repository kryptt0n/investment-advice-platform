package com.investmentadvice.identity.feign;

import com.investmentadvice.identity.dto.CredentialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ss-credentials")
public interface CredentialClient {

    @PostMapping("/login")
    ResponseEntity<Void> login(@RequestBody CredentialDTO credentialDTO);

    @PostMapping("/register")
    ResponseEntity<Void> register(@RequestBody CredentialDTO credentialDTO);
}
