package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.dto.ResponseToken;
import com.onlineinsuranceclaim.dto.UserDTO;
import com.onlineinsuranceclaim.model.UserData;

public interface IUserService {

    UserData userRegistration(RegistrationDTO registrationDTO);

    ResponseToken userLogin(UserDTO userDTO);
}
