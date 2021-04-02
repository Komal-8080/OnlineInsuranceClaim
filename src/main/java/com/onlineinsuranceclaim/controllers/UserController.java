package com.onlineinsuranceclaim.controllers;

import com.onlineinsuranceclaim.dto.ResponseToken;
import com.onlineinsuranceclaim.dto.UserDTO;
import com.onlineinsuranceclaim.dto.ResponseDTO;
import com.onlineinsuranceclaim.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService loginService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@Valid @RequestBody UserDTO userDTO) {
        ResponseToken userData = loginService.userLogin(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Logged in sucessfully", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
