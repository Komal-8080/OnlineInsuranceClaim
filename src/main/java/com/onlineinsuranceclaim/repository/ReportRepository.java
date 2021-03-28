package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.ReportGeneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<ReportGeneration, Long> {
    Optional<ReportGeneration> findByClaimNumber(Long claimNumber);
}
