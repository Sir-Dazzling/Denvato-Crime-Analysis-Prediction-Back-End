package com.example.denvatocrimeanalyticsplatform.dao;

import com.example.denvatocrimeanalyticsplatform.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String>
{
    VerificationToken findByVerificationToken( String verificationToken);
}