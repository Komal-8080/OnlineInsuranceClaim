package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.ReportGenerationDTO;
import com.onlineinsuranceclaim.dto.ResponseDTO;
import com.onlineinsuranceclaim.model.ReportGeneration;
import com.onlineinsuranceclaim.service.IClaimHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/claimHandler")
public class ClaimHandlerController {

    @Autowired
    IClaimHandlerService iClaimHandlerService;

    @PostMapping("/ReportGeneration")
    public  ResponseEntity<ResponseDTO> GenerateReport(@RequestHeader String token, @RequestBody ReportGenerationDTO reportGenerationDTO) {
        ReportGeneration reportGeneration  = null;
        reportGeneration = iClaimHandlerService.GenerateReport(token,reportGenerationDTO);
        ResponseDTO respDTO = new ResponseDTO("Report Generated Successfully", reportGeneration);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}
