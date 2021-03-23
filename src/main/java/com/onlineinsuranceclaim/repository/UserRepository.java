package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData, Integer> {

    Optional<UserData> findByUserName(String userName);
}
