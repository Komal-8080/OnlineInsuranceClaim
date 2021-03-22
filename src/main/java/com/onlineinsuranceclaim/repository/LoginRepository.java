package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.dto.LoginDTO;
import com.onlineinsuranceclaim.model.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginData, Integer> {

    Optional<LoginData> findByUserName(String userName);


    Optional<LoginData> findByUserNameAndPassword(String userName, String password);
}
