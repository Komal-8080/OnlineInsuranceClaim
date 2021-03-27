package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.PolicyData;
import com.onlineinsuranceclaim.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolicyDetailsRepository extends JpaRepository<PolicyData, Integer> {

//    List<PolicyData> findByUserName(String userName);

    Optional<UserData> findByUserId(Long id);

    Optional<PolicyData> findByPolicyNumber(Long policyNumber);
}
