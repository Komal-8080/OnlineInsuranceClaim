package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.ClaimPolicyDTO;
import com.onlineinsuranceclaim.dto.PolicyDataDTO;
import com.onlineinsuranceclaim.model.ClaimPolicy;
import com.onlineinsuranceclaim.model.PolicyData;
import java.util.List;

public interface IClaimService {

    PolicyData CreatePolicy(String token,PolicyDataDTO policyDataDTO);

    List<PolicyData> getUserPolicies(String token);

    ClaimPolicy claimPolicy(String token, Long policyNumber, ClaimPolicyDTO claimPolicyDTO);
}
