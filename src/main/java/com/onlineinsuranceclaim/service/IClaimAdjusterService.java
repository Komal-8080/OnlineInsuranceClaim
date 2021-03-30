package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.CreateProfileDTO;
import com.onlineinsuranceclaim.model.CreateProfile;

public interface IClaimAdjusterService {
    CreateProfile createNewProfile(String token, CreateProfileDTO createProfileDTO);
}
