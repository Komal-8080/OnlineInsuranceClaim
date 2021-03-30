package com.onlineinsuranceclaim.repository;

import com.onlineinsuranceclaim.model.CreateProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<CreateProfile, String> {

    Optional<CreateProfile> findByIdAndUserName(Long id, String userName);
}
