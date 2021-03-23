package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.dto.UserDTO;
import com.onlineinsuranceclaim.exceptions.LoginException;
import com.onlineinsuranceclaim.model.UserData;
import com.onlineinsuranceclaim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private TokenUtil tokenUtil;

    @Override
    public UserData createLoginData(RegistrationDTO registrationDTO) {
        UserData userData = null;
        userData = new UserData(registrationDTO.getUserName(),passwordEncoder.encode(registrationDTO.getPassword()),registrationDTO.getFirstName(),registrationDTO.getLastName(),registrationDTO.getPhone());
        Optional<UserData> useralreadyPresent = userRepository.findByUserName(userData.getUserName());
        if (useralreadyPresent.isPresent()) {
            throw new LoginException("User Already Exists");
        }else {
            return userRepository.save(userData);
        }
    }

    @Override
    public UserData getLoginDataByUserName(UserDTO userDTO) {
        return userRepository
                .findByUserName(userDTO.getUserName())
               .orElseThrow(() -> new LoginException("User Does Not Exists"));
    }
}
