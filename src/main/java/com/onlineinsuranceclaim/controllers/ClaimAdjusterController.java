package com.onlineinsuranceclaim.controllers;


import com.onlineinsuranceclaim.dto.CreateProfileDTO;
import com.onlineinsuranceclaim.dto.ResponseDTO;
import com.onlineinsuranceclaim.model.CreateProfile;
import com.onlineinsuranceclaim.service.IClaimAdjusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/claimAdjuster")
public class ClaimAdjusterController {

    @Autowired
    private IClaimAdjusterService iClaimAdjusterService;

    @PostMapping("/newProfile")
    public ResponseEntity<ResponseDTO> profileCreation(@RequestHeader String token, @RequestBody CreateProfileDTO createProfileDTO) {
        CreateProfile createProfile  = null;
        createProfile = iClaimAdjusterService.createNewProfile(token,createProfileDTO);
        ResponseDTO respDTO = new ResponseDTO("Profile Created Successfully", createProfile);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
