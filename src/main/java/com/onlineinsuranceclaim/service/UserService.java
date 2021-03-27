package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.dto.ResponseToken;
import com.onlineinsuranceclaim.dto.UserDTO;
import com.onlineinsuranceclaim.exceptions.UserException;
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

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public UserData userRegistration(RegistrationDTO registrationDTO) {
        Optional<UserData> byUserName = userRepository.findByUserName(registrationDTO.getUserName());
        if (byUserName.isPresent()) {
            throw new UserException("User Already Exists");
        }
        UserData userData = new UserData(registrationDTO.getUserName(),passwordEncoder.encode(registrationDTO.getPassword()),registrationDTO.getFirstName(),registrationDTO.getLastName(),registrationDTO.getPhone());
        return userRepository.save(userData);
    }

    @Override
    public ResponseToken userLogin(UserDTO userDTO) {
        Optional<UserData> byUserName = userRepository.findByUserName(userDTO.getUserName());
        if (byUserName.isPresent()) {
            return authentication(byUserName,userDTO.getPassword());
        }
        throw new UserException("Invalid UserName Or Password");

    }

    private ResponseToken authentication(Optional<UserData> userDTO, String password) {
        ResponseToken response = new ResponseToken();
            boolean status = passwordEncoder.matches(password, userDTO.get().getPassword());
            if (status == true) {
                String token = tokenUtil.createToken(userDTO.get().getUserId());
                response.setToken(token);
                response.setStatusCode(200);
                response.setStatusMessage("User Logged In Successfully");
                return response;
            }
            throw new UserException("Invalid UserName Or Password");
        }

}


