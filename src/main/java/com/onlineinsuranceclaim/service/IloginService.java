package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.LoginDTO;
import com.onlineinsuranceclaim.model.LoginData;
import java.util.List;

public interface IloginService {

    LoginData getLoginDataByUserName(String name, String userName);

    LoginData createLoginData(LoginDTO loginDTO);

}
