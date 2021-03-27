package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.*;
import com.onlineinsuranceclaim.model.PolicyData;
import com.onlineinsuranceclaim.service.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/claim")
public class ClaimController {

    @Autowired
    private IClaimService iClaimService;

    @PostMapping("/newPolicy/{token}")
    public ResponseEntity<ResponseDTO> enterPolicyDetails(@PathVariable String token,@RequestBody PolicyDataDTO policyDataDTO) {
        PolicyData policyData  = null;
        policyData = iClaimService.CreatePolicy(token,policyDataDTO);
        ResponseDTO respDTO = new ResponseDTO("Details Saved Sucessfully", policyData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

//    @GetMapping("/getPolicy/{userName}")
//    public ResponseEntity<ResponseDTO> onClaim(@PathVariable("userName") String userName) {
//        List<PolicyData> policyDataList = null;
//        policyDataList = iClaimService.getUserPolicies(userName);
//        ResponseDTO respDTO = new ResponseDTO("Get Call Sucessfull", policyDataList);
//        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
//    }
//
//    @PutMapping("/makeClaim")
//    public ResponseEntity<ResponseDTO> makeClaim(@PathVariable("token") String token,@RequestParam("policyNumber") Long policyNumber,@RequestBody ClaimPolicyDTO claimPolicyDTO) {
//        ClaimPolicy claimPolicy = null;
//        claimPolicy = iClaimService.getMakeClaim(token,policyNumber, claimPolicyDTO);
//        ResponseDTO respDTO = new ResponseDTO("Get Call Sucessfull", claimPolicy);
//        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
//    }
//
////    @PostMapping("/ReprotGeneration")
////    public ResponseEntity<ResponseDTO> reportGeneration(@RequestBody MakeClaimDTO makeClaimDTO){
////        MakeClaim makeClaim = null;
////        makeClaim = iClaimService.getReportGeneration()
////    }
//
//    @PostMapping("/ReprotGeneration")
//    public ResponseEntity<ResponseDTO> profileCreation(@RequestBody ProfileCreationDTO profileCreationDTO) {
//        ProfileCreation profileCreation  = null;
//        profileCreation = iClaimService.createNewProfile(profileCreationDTO);
//        ResponseDTO respDTO = new ResponseDTO("Profile Created Successfully", profileCreation);
//        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
//    }
//
//
//    @PostMapping("/ProfileCreation")
//    public  ResponseEntity<ResponseDTO> reportGeneration(@RequestBody ReportGenerationDTO reportGenerationDTO) {
//         ReportGeneration reportGeneration  = null;
//        reportGeneration = iClaimService.createNewReport(reportGenerationDTO);
//        ResponseDTO respDTO = new ResponseDTO("Report Generated Successfully", reportGeneration);
//        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
//    }
}
