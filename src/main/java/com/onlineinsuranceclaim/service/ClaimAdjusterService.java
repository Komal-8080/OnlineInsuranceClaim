package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.exceptions.UserException;
import com.onlineinsuranceclaim.model.UserData;
import com.onlineinsuranceclaim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClaimAdjusterService implements IClaimAdjusterService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public UserData userRegistration(String token,RegistrationDTO registrationDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<UserData> byRoleCode = userRepository.findByUserId(id);
        if (byRoleCode.get().getRoleCode().equals("ClaimAdjuster")) {
            Optional<UserData> byUserName = userRepository.findByUserName(registrationDTO.getUserName());
            if (byUserName.isPresent()) {
                throw new UserException("User Already Exists");
            }
            UserData userData = new UserData(registrationDTO.getUserName(), passwordEncoder.encode(registrationDTO.getPassword()), registrationDTO.getFirstName(), registrationDTO.getLastName(), registrationDTO.getPhone(), registrationDTO.getEmail(), registrationDTO.getRoleCode());
            return userRepository.save(userData);
        } else
            throw new UserException("Invalid User");
    }
}
