package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.ClaimPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaimPolicyRepository extends JpaRepository<ClaimPolicy, Long > {
    Optional<ClaimPolicy> findByPolicyNumber(Long policyNumber);
}
