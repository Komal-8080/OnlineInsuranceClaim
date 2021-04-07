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
        userData.get().getPolicyDataList().add(policyData);
        userRepository.save(userData.get());
        PolicyData savePolicy = policyDetailsRepository.save(policyData);
        emailService.sendMail(token,"Thank You For Taking Policy","Dear "+userData.get().getUserName()+"\n"
                +"We are glad to inform you that your policy is succesfully issued.Kindly find the below policy details."+"\n"+"Policy Number:"+policyData.getPolicyNumber()+"\n"
        + "Account Number:"+policyData.getAccountNumber()+"\n"+"Premium Amount:"+policyData.getPremiumAmount()+"\n"+"Thank You");
        return savePolicy;
    }

    @Override
    public List<PolicyData> getUserPolicies(String token) {
        Long id = tokenUtil.decodeToken(token);
        List<PolicyData> policyData = policyDetailsRepository.findByUserId(id);
        if (policyData.isEmpty()) {
            throw new UserException("Policy does not exists");
        } else {
            for ( PolicyData policy : policyData) {
                Optional<ClaimPolicy> claimByPolicy = claimPolicyRepository.findByPolicyNumber(policy.getPolicyNumber());
                if(claimByPolicy.isPresent()){
                    policy.setClaimPolicy(claimByPolicy.get());
                }
            }
            return policyData;
        }
    }

    @Override
    public ClaimPolicy makeClaim(String token, Long policyNumber, ClaimPolicyDTO claimPolicyDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByUserIdAndPolicyNumber(id, policyNumber);
        Optional<ClaimPolicy> claimByPolicy = claimPolicyRepository.findByPolicyNumber(policyNumber);
        if (byPolicyNumber.isPresent() & !claimByPolicy.isPresent()) {
            ClaimPolicy claimPolicy = new ClaimPolicy(claimPolicyDTO);
            claimPolicy.setPolicyNumber(policyNumber);
            Optional<UserData> userData = userRepository.findByUserId(id);
            policyDetailsRepository.save(byPolicyNumber.get());
            ClaimPolicy saveClaim = claimPolicyRepository.save(claimPolicy);
            emailService.sendMail(token,"Regarding Claim for Policy Number "+byPolicyNumber.get().getPolicyNumber(),"Dear "+userData.get().getUserName()+"\n"
                    +"This is To inform you that your claim request is sucessfully submitted.");
            return saveClaim;
        } else {
            throw new UserException("Policy Does Not Exists");
        }
    }

}
