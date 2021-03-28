package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.*;
import com.onlineinsuranceclaim.model.ClaimPolicy;
import com.onlineinsuranceclaim.model.PolicyData;
import com.onlineinsuranceclaim.service.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/Insured")
public class InsuredController {

    @Autowired
    private IClaimService iClaimService;

    @PostMapping("/CreatePolicy")
    public ResponseEntity<ResponseDTO> CreatePolicy(@RequestHeader String token,@RequestBody PolicyDataDTO policyDataDTO) {
        PolicyData policyData  = null;
        policyData = iClaimService.CreatePolicy(token,policyDataDTO);
        ResponseDTO respDTO = new ResponseDTO("Details Saved Sucessfully", policyData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/getPolicy")
    public ResponseEntity<ResponseDTO> getUserPolicies(@RequestHeader String token) {
        PolicyData policyData = null;
        policyData = iClaimService.getUserPolicies(token);
        ResponseDTO respDTO = new ResponseDTO("Get Call Sucessfull", policyData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/ClaimPolicy")
    public ResponseEntity<ResponseDTO> claimPolicy(@RequestHeader String token,@RequestParam("policyNumber") Long policyNumber,@RequestBody ClaimPolicyDTO claimPolicyDTO) {
        ClaimPolicy claimPolicy = null;
        claimPolicy = iClaimService.claimPolicy(token,policyNumber, claimPolicyDTO);
        ResponseDTO respDTO = new ResponseDTO("Get Call Sucessfull", claimPolicy);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

//    @PostMapping("/ProfileCreation")
//    public  ResponseEntity<ResponseDTO> reportGeneration(@RequestBody ReportGenerationDTO reportGenerationDTO) {
//         ReportGeneration reportGeneration  = null;
//        reportGeneration = iClaimService.createNewReport(reportGenerationDTO);
//        ResponseDTO respDTO = new ResponseDTO("Report Generated Successfully", reportGeneration);
//        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
//    }

//    public ResponseEntity<ResponseDTO> profileCreation(@RequestBody ProfileCreationDTO profileCreationDTO) {
//        ProfileCreation profileCreation  = null;
//        profileCreation = iClaimService.createNewProfile(profileCreationDTO);
//        ResponseDTO respDTO = new ResponseDTO("Profile Created Successfully", profileCreation);
//        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
//    }
}
