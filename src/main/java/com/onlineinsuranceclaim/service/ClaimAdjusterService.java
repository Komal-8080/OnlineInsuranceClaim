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
    public UserData firstClaimAdjuster(RegistrationDTO registrationDTO) {
        if(userRepository.count() == 0) {
            UserData userData = new UserData(registrationDTO);
            userData.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
            userData.setRoleCode("ClaimAdjuster");
            return userRepository.save(userData);
        }else
            throw new UserException("Only Claim Adjuster can register users");
    }

    @Override
    public UserData userRegistration(String token,RegistrationDTO registrationDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<UserData> byRoleCode = userRepository.findByUserId(id);
        if (byRoleCode.get().getRoleCode().equals("ClaimAdjuster")) {
            Optional<UserData> byUserName = userRepository.findByUserName(registrationDTO.getUserName());
            if (byUserName.isPresent()) {
                throw new UserException("User Already Exists");
            }
            UserData userData = new UserData(registrationDTO);
            userData.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
            return userRepository.save(userData);
        } else
            throw new UserException("Invalid User");
    }

}
