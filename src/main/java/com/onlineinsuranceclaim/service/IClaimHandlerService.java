package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.model.ReportGeneration;
import com.onlineinsuranceclaim.model.UserData;

public interface IClaimHandlerService {
    ReportGeneration GenerateReport(String token, Long policyNumber, Long claimNumber);

    UserData UserDetails(String token, Long policyNumber, Long claimNumber);
}
