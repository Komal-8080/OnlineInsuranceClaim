package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.LoginDTO;
import com.onlineinsuranceclaim.exceptions.LoginException;
import com.onlineinsuranceclaim.model.LoginData;
import com.onlineinsuranceclaim.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements IloginService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public LoginData getLoginDataByUserName(String userName,String password) {
        return loginRepository
                .findByUserNameAndPassword(userName,password)
                .orElseThrow(() -> new LoginException("Invalid UserName or Password"));
    }

    @Override
    public LoginData createLoginData(LoginDTO loginDTO) {
        LoginData loginData = null;
        loginData = new LoginData(loginDTO.getUserName(),passwordEncoder.encode(loginDTO.getPassword()));
        Optional<LoginData> useralreadyPresent = loginRepository.findByUserName(loginData.getUserName());
        if (useralreadyPresent.isPresent()) {
            throw new LoginException("User Already Exists");
        }else {
            return loginRepository.save(loginData);
        }
    }
}
