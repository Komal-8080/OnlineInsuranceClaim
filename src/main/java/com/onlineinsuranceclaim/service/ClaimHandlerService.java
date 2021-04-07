package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.exceptions.UserException;
import com.onlineinsuranceclaim.model.ClaimPolicy;
import com.onlineinsuranceclaim.model.PolicyData;
import com.onlineinsuranceclaim.model.ReportGeneration;
import com.onlineinsuranceclaim.model.UserData;
import com.onlineinsuranceclaim.repository.ClaimPolicyRepository;
import com.onlineinsuranceclaim.repository.PolicyDetailsRepository;
import com.onlineinsuranceclaim.repository.ReportRepository;
import com.onlineinsuranceclaim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClaimHandlerService implements IClaimHandlerService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PolicyDetailsRepository policyDetailsRepository;

    @Autowired
    private ClaimPolicyRepository claimPolicyRepository;

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private ClaimService claimService;

    @Override
    public ReportGeneration GenerateReport(String token, Long policyNumber, Long claimNumber) {
        Long id = tokenUtil.decodeToken(token);
        Optional<UserData> byRoleCode = userRepository.findByUserId(id);
        if(byRoleCode.get().getRoleCode().equals("ClaimHandler") || byRoleCode.get().getRoleCode().equals("ClaimAdjuster")) {
            Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByUserIdAndPolicyNumber(id,policyNumber);
            Optional<ClaimPolicy> byClaimNumber = claimPolicyRepository.findByClaimNumber(claimNumber);
            if(byPolicyNumber.isPresent() & byClaimNumber.isPresent()) {
                ReportGeneration reportGeneration = new ReportGeneration();
                reportGeneration.setClaimNumber(byClaimNumber.get().getClaimNumber());
                reportGeneration.setClaimReason(byClaimNumber.get().getClaimReason());
                reportGeneration.setClaimType(byClaimNumber.get().getClaimType());
                reportGeneration.setDetails(this.UserDetails(token,policyNumber,claimNumber));
                return reportRepository.save(reportGeneration);
            }else {
                throw new UserException("Report Does not Exists");
            }
        }else
            throw new UserException("Invalid User");
    }

    @Override
    public UserData UserDetails(String token, Long policyNumber, Long claimNumber) {
        Long id = tokenUtil.decodeToken(token);
        Optional<UserData> byRoleCode = userRepository.findByUserId(id);
        if (byRoleCode.get().getRoleCode().equals("ClaimHandler") || byRoleCode.get().getRoleCode().equals("ClaimAdjuster")) {
            Optional<PolicyData> byPolicyNumber = policyDetailsRepository.findByUserIdAndPolicyNumber(id, policyNumber);
            Optional<ClaimPolicy> byClaimNumber = claimPolicyRepository.findByClaimNumber(claimNumber);
            if (byPolicyNumber.isPresent() & byClaimNumber.isPresent()) {
                byRoleCode.get().getPolicyDataList().add(byPolicyNumber.get());
            }
            else throw new UserException("User Not Found");
        }
        return byRoleCode.get();
    }
}
