package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    Optional<UserData> findByUserName(String userName);

    Optional<UserData> findByUserId(Long id);

    Optional<UserData> findByRoleCode(String roleCode);
}
