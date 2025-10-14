package com.investmentadvice.credentials.repositories;

import com.investmentadvice.credentials.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {
    boolean existsByEmail(String email);
}
