package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.ClaimPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimPolicyRepository extends JpaRepository<ClaimPolicy, Long > {
}
