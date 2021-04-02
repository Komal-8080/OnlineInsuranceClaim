package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.model.UserData;

public interface IClaimAdjusterService {

    UserData userRegistration(String token,RegistrationDTO registrationDTO);
}
