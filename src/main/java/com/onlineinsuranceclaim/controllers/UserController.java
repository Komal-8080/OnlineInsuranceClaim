package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.RegistrationDTO;
import com.onlineinsuranceclaim.dto.ResponseToken;
import com.onlineinsuranceclaim.dto.UserDTO;
import com.onlineinsuranceclaim.dto.ResponseDTO;
import com.onlineinsuranceclaim.model.UserData;
import com.onlineinsuranceclaim.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService loginService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody UserDTO userDTO) {
        ResponseToken userData = null;
        userData = loginService.userLogin(userDTO);
        ResponseDTO respDTO = new ResponseDTO("User Logged in sucessfully", userData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> userRegistration(@RequestBody RegistrationDTO registrationDTO) {
        UserData userData = null;
        userData = loginService.userRegistration(registrationDTO);
        ResponseDTO respDTO = new ResponseDTO("User Registered Successfully", userData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


}
