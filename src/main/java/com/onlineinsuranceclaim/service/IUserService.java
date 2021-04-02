package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.ResponseToken;
import com.onlineinsuranceclaim.dto.UserDTO;

public interface IUserService {
    ResponseToken userLogin(UserDTO userDTO);
}
