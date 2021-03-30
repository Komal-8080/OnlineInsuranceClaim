package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.Utility.TokenUtil;
import com.onlineinsuranceclaim.dto.ReportGenerationDTO;
import com.onlineinsuranceclaim.exceptions.UserException;
import com.onlineinsuranceclaim.model.PolicyData;
import com.onlineinsuranceclaim.model.ReportGeneration;
import com.onlineinsuranceclaim.repository.PolicyDetailsRepository;
import com.onlineinsuranceclaim.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClaimHandlerService implements IClaimHandlerService{

    @Autowired
    private PolicyDetailsRepository policyDetailsRepository;

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public ReportGeneration GenerateReport(String token,ReportGenerationDTO reportGenerationDTO) {
        Long id = tokenUtil.decodeToken(token);
        PolicyData policyData = policyDetailsRepository.findByUserId(id);
        Optional<ReportGeneration> byClaimNumber = reportRepository.findByClaimNumber(reportGenerationDTO.getClaimNumber());
        if (byClaimNumber.isPresent()) {
            throw new UserException("Report Already Exists");
        }
        ReportGeneration reportGeneration = new ReportGeneration(reportGenerationDTO);
        return reportRepository.save(reportGeneration);
    }

}
