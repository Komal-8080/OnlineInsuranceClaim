package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.ClaimPolicyDTO;
import com.onlineinsuranceclaim.dto.ResponseDTO;
import com.onlineinsuranceclaim.model.ReportGeneration;
import com.onlineinsuranceclaim.service.IClaimHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claimHandlerandclaimAdjuster")
public class ClaimHandlerController {

    @Autowired
    IClaimHandlerService iClaimHandlerService;

    private ClaimPolicyDTO claimPolicy;

    @GetMapping("/ReportGeneration")
    public  ResponseEntity<ResponseDTO> GenerateReport(@RequestHeader String token,@RequestParam("policyNumber") Long policyNumber,@RequestParam("claimNumber") Long claimNumber) {
        ReportGeneration reportGeneration  = iClaimHandlerService.GenerateReport(token,policyNumber,claimNumber);
        ResponseDTO responseDTO = new ResponseDTO("Report Generated Successfully", reportGeneration);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
