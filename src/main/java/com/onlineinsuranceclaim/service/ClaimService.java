package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.dto.*;
import com.onlineinsuranceclaim.exceptions.UserException;
import com.onlineinsuranceclaim.model.*;
import com.onlineinsuranceclaim.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimService implements IClaimService {

    @Autowired
    private PolicyDetailsRepository policyDetailsRepository;

    @Autowired
    private ClaimPolicyRepository claimPolicyRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public PolicyData CreatePolicy(String token, PolicyDataDTO policyDataDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByPolicyNumber(policyDataDTO.getPolicyNumber());
        if (byPolicyNumber.isPresent()) {
            throw new UserException("Policy Already Exists");
        }
        PolicyData policyData = new PolicyData(policyDataDTO);
        policyData.setUserId(id);
        return policyDetailsRepository.save(policyData);
    }

    @Override
    public PolicyData getUserPolicies(String token) {
        Long id = tokenUtil.decodeToken(token);
        return policyDetailsRepository.findByUserId(id);
    }

    @Override
    public ClaimPolicy claimPolicy(String token, Long policyNumber, ClaimPolicyDTO claimPolicyDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByPolicyNumber(policyNumber);
        if(byPolicyNumber.isPresent()) {
            ClaimPolicy claimPolicy = new ClaimPolicy(claimPolicyDTO);
            claimPolicy.setUserId(id);
            claimPolicy.setPolicyNumber(policyNumber);
            return claimPolicyRepository.save(claimPolicy);
        }else {
            throw new UserException("Policy Does Not Exists");
        }

    }


//
//    @Override
//    public ProfileCreation createNewProfile(ProfileCreationDTO profileCreationDTO) {
//        Optional<ProfileCreation> byUserName = profileRepository.findByUserName(profileCreationDTO.getUserName());
//        if (byUserName.isPresent()) {
//            throw new UserException("User Already Exists");
//        }
//        ProfileCreation profileCreation = new ProfileCreation(profileCreationDTO);
//        return profileRepository.save(profileCreation);
//    }

}
