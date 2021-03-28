package com.onlineinsuranceclaim.service;

import com.onlineinsuranceclaim.dto.ReportGenerationDTO;
import com.onlineinsuranceclaim.model.ReportGeneration;

public interface IClaimHandlerService {
    ReportGeneration GenerateReport(String token,ReportGenerationDTO reportGenerationDTO);
}
