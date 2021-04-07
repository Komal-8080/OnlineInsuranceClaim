package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.*;
import com.onlineinsuranceclaim.model.ClaimPolicy;
import com.onlineinsuranceclaim.model.PolicyData;
import com.onlineinsuranceclaim.service.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Insured")
public class InsuredController {

    @Autowired
    private IClaimService iClaimService;

    @PostMapping("/CreatePolicy")
    public ResponseEntity<ResponseDTO> CreatePolicy(@RequestHeader String token,@Valid @RequestBody PolicyDataDTO policyDataDTO) {
        PolicyData policyData  = iClaimService.CreatePolicy(token,policyDataDTO);
        ResponseDTO responseDTO = new ResponseDTO("Details Saved Sucessfully", policyData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getPolicy")
    public ResponseEntity<ResponseDTO> getUserPolicies(@RequestHeader String token) {
        List<PolicyData> policyData = policyData = iClaimService.getUserPolicies(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Sucessfull", policyData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/ClaimPolicy")
    public ResponseEntity<ResponseDTO> claimPolicy(@RequestHeader String token,@RequestParam("policyNumber") Long policyNumber,@Valid @RequestBody ClaimPolicyDTO claimPolicyDTO) {
        ClaimPolicy claimPolicy = iClaimService.makeClaim(token,policyNumber, claimPolicyDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Sucessfull", claimPolicy);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
