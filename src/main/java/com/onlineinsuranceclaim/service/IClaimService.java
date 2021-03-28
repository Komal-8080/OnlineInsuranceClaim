package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.ClaimPolicyDTO;
import com.onlineinsuranceclaim.dto.PolicyDataDTO;
import com.onlineinsuranceclaim.model.ClaimPolicy;
import com.onlineinsuranceclaim.model.PolicyData;

import java.util.List;

public interface IClaimService {

    PolicyData CreatePolicy(String token,PolicyDataDTO policyDataDTO);

    PolicyData getUserPolicies(String token);

    ClaimPolicy claimPolicy(String token, Long policyNumber, ClaimPolicyDTO claimPolicyDTO);

//    List<PolicyData> getUserPolicies(String userName);
//
//    ClaimPolicy getMakeClaim(String token, long policyNumber, ClaimPolicyDTO claimPolicyDTO);
//
//    ProfileCreation createNewProfile(ProfileCreationDTO profileCreationDTO);
//
//    ReportGeneration createNewReport(ReportGenerationDTO reportGenerationDTO);
}
