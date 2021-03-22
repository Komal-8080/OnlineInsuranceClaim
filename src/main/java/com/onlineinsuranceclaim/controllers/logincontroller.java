package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.LoginDTO;
import com.onlineinsuranceclaim.dto.ResponseDTO;
import com.onlineinsuranceclaim.model.LoginData;
import com.onlineinsuranceclaim.service.IloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class logincontroller {

    @Autowired
    private IloginService loginService;

    @GetMapping(" ")
    public ResponseEntity<ResponseDTO> getLoginDataByUserName(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password) {
        LoginData loginData = null;
        loginData = loginService.getLoginDataByUserName(userName,password);
        ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful", loginData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createLoginData(@RequestBody LoginDTO loginDTO) {
//        log.debug("Employee DTO: "+loginDTO.toString());
        LoginData loginData = null;
        loginData = loginService.createLoginData(loginDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", loginData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}
