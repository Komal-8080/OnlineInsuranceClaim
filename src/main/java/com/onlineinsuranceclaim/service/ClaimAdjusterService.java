package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.dto.CreateProfileDTO;
import com.onlineinsuranceclaim.exceptions.UserException;
import com.onlineinsuranceclaim.model.CreateProfile;
import com.onlineinsuranceclaim.model.PolicyData;
import com.onlineinsuranceclaim.repository.PolicyDetailsRepository;
import com.onlineinsuranceclaim.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClaimAdjusterService implements IClaimAdjusterService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public CreateProfile createNewProfile(String token, CreateProfileDTO createProfileDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<CreateProfile> byUserName = profileRepository.findByIdAndUserName(id,createProfileDTO.getUserName());
        if (byUserName.isPresent()) {
            throw new UserException("User Already Exists");
        }
        CreateProfile createProfile = new CreateProfile(createProfileDTO);
        createProfile.setId(id);
        return profileRepository.save(createProfile);
    }

}
