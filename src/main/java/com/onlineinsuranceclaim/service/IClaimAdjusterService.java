package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.model.UserData;

public interface IClaimAdjusterService {

    UserData firstClaimAdjuster(RegistrationDTO registrationDTO);

    UserData userRegistration(String token,RegistrationDTO registrationDTO);
}
