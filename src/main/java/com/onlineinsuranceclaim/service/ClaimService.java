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
    private UserRepository userRepository;

    @Autowired
    private PolicyDetailsRepository policyDetailsRepository;

    @Autowired
    private ClaimPolicyRepository claimPolicyRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private EmailService emailService;

    @Override
    public PolicyData CreatePolicy(String token, PolicyDataDTO policyDataDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByUserIdAndPolicyNumber(id, policyDataDTO.getPolicyNumber());
        if (byPolicyNumber.isPresent()) {
            throw new UserException("Policy Already Exists");
        }
        PolicyData policyData = new PolicyData(policyDataDTO);
        policyData.setUserId(id);
        Optional<UserData> userData = userRepository.findByUserId(id);
        emailService.sendMail(token,"Thank You For Taking Policy","Dear "+userData.get().getUserName()+"\n"
                +"We are glad to inform you that your policy is succesfully issued.Kindly find the below policy details."+"\n"+"Policy Number:"+policyData.getPolicyNumber()+"\n"
        + "Account Number:"+policyData.getAccountNumber()+"\n"+"Premium Amount:"+policyData.getPremiumAmount()+"\n"+"Thank You");
        return policyDetailsRepository.save(policyData);
    }

    @Override
    public List<PolicyData> getUserPolicies(String token) {
        Long id = tokenUtil.decodeToken(token);
        List<PolicyData> policyData = policyDetailsRepository.findByUserId(id);
        if (policyData.isEmpty()) {
            throw new UserException("Policy does not exists");
        } else
            return policyDetailsRepository.findByUserId(id);
    }

    @Override
    public ClaimPolicy claimPolicy(String token, Long policyNumber, ClaimPolicyDTO claimPolicyDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByUserIdAndPolicyNumber(id, policyNumber);
        Optional<ClaimPolicy> byPolicy = claimPolicyRepository.findByPolicyNumber(policyNumber);
        if (byPolicyNumber.isPresent() & !byPolicy.isPresent()) {
            ClaimPolicy claimPolicy = new ClaimPolicy(claimPolicyDTO);
            claimPolicy.setPolicyNumber(policyNumber);
            PolicyData policyData = new PolicyData();
            Optional<UserData> userData = userRepository.findByUserId(id);
            emailService.sendMail(token,"Regarding Claim for Policy Number "+byPolicyNumber.get().getPolicyNumber(),"Dear "+userData.get().getUserName()+"\n"
                    +"This is To inform you that your claim request is sucessfully submitted.");
            return claimPolicyRepository.save(claimPolicy);
        } else {
            throw new UserException("Policy Does Not Exists");
        }
    }

}
