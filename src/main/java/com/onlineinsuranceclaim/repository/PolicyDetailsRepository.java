package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.PolicyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PolicyDetailsRepository extends JpaRepository<PolicyData, Long> {

    PolicyData findByUserId(Long id);

    Optional<PolicyData> findByUserIdAndPolicyNumber(Long id, Long policyNumber);
}
