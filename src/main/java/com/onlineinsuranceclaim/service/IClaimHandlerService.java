package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.model.ReportGeneration;

public interface IClaimHandlerService {
    ReportGeneration GenerateReport(String token, Long policyNumber, Long claimNumber);
}
