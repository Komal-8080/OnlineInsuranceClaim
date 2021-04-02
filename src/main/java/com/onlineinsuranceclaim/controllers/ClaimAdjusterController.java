package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.dto.ResponseDTO;
import com.onlineinsuranceclaim.model.UserData;
import com.onlineinsuranceclaim.service.IClaimAdjusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/claimAdjuster")
public class ClaimAdjusterController {

    @Autowired
    private IClaimAdjusterService iClaimAdjusterService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> userRegistration(@RequestHeader String token,@Valid @RequestBody RegistrationDTO registrationDTO) {
        UserData userData = null;
        userData = iClaimAdjusterService.userRegistration(token,registrationDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Registered Successfully", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
