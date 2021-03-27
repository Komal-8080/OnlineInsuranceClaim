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
    private UserRepository userRepository;

    @Autowired
    private TokenUtil tokenUtil;

//    public UserData getUserDataById(String token){
//        Long id = tokenUtil.decodeToken(token);
//        return userRepository.findById(id);
//    }

    @Override
    public PolicyData CreatePolicy(String token, PolicyDataDTO policyDataDTO) {
        Long id = tokenUtil.decodeToken(token);
        Optional<UserData> userData = policyDetailsRepository.findByUserId(id);
        Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByPolicyNumber(policyDataDTO.getPolicyNumber());
        if (byPolicyNumber.isPresent()) {
            throw new UserException("Policy Already Exists");
        }
        PolicyData policyData = new PolicyData(policyDataDTO);
        policyData.setUserId(id);

        return policyDetailsRepository.save(policyData);
    }

//    @Override
//    public PolicyData CreatePolicy(String token,PolicyDataDTO policyDataDTO) {
//        int id = tokenUtil.decodeToken(token);
//        Optional<UserData> userData = policyDetailsRepository.findByUserId(id);
//        Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByPolicyNumberAndUserId(policyDataDTO.getPolicyNumber(),id);
//        System.out.println("policyNumber:"+byPolicyNumber);
//        if (byPolicyNumber.isPresent()) {
//            throw new UserException("Policy Already Exists");
//        }
//
//        System.out.println("Id"+id);
//        PolicyData policyData = null;
//        policyData = new PolicyData(policyDataDTO);
//
//
//        userData.get().getPolicyDataList().add(policyData);
//        userRepository.save(userData.get());
//        return policyDetailsRepository.save(policyData);
//    }

//    @Override
//    public List<PolicyData> getUserPolicies(String userName) {
//        return policyDetailsRepository.findByUserName(userName);
//    }
//
//    @Override
//    public ClaimPolicy getMakeClaim(String token, long policyNumber, ClaimPolicyDTO claimPolicyDTO) {
////        if (makeClaimDTO.getPolicyNumber() != policyNumber) {
////            throw new UserException("Policy Does not Exists!!");
////        }else {
////         int id = tokenUtil.decodeToken(token);
//           ClaimPolicy claimPolicy = null;
//           claimPolicy = new ClaimPolicy(claimPolicyDTO.getClaimNumber(), claimPolicyDTO.getClaimReason(), claimPolicyDTO.getClaimType(), claimPolicyDTO.getAccidentCity(), claimPolicyDTO.getAccidentState(), claimPolicyDTO.getAccidentZip(), claimPolicyDTO.getAccidentLocation(), claimPolicyDTO.getPolicyNumber());
//           return makeClaimRepository.save(claimPolicy);
////        }
//
//    }
//
//
//
//    private ResponseToken authentication(ClaimPolicyDTO claimPolicyDTO, String token) {
//
//        int id = tokenUtil.decodeToken(token);
//        Optional<PolicyData> policyData = policyDetailsRepository.findByUserid(id);
//        claimPolicyDTO.setPolicyNumber();
//        policyData.get().getPolicyNumber().add(policyData);
//        policyDetailsRepository.save(policyData);
//        return response;
//        }
//
//    }

//    @Override
//    public ReportGeneration createNewReport(ReportGenerationDTO reportGenerationDTO) {
//        Optional<ReportGeneration> byClaimNumber = reportRepository.findByClaimNumber(reportGenerationDTO.getClaimNumber());
//        if (byClaimNumber.isPresent()) {
//            throw new UserException("Report Already Exists");
//        }
//        ReportGeneration reportGeneration = new ReportGeneration(reportGenerationDTO);
//        return reportRepository.save(reportGeneration);
//    }
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
//
//
//    @Override
//    public PolicyData EnterPolicyDetails(PolicyDataDTO policyDataDTO) {
//        return null;
//    }
}
