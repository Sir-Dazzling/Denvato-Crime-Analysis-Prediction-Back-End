package com.example.denvatocrimeanalyticsplatform.dao;

import com.example.denvatocrimeanalyticsplatform.model.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRefreshRepository extends JpaRepository<JwtRefreshToken, String>
{
}