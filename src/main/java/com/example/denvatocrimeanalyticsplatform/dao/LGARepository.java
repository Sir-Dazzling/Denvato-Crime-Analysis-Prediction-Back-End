package com.example.denvatocrimeanalyticsplatform.dao;

import com.example.denvatocrimeanalyticsplatform.model.ELocalGovtArea;
import com.example.denvatocrimeanalyticsplatform.model.LocalGovtArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LGARepository extends JpaRepository<LocalGovtArea, Integer>
{
    Optional<LocalGovtArea> findByName(ELocalGovtArea name);
}
