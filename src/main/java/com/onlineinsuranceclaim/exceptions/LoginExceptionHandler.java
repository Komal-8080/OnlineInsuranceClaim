package com.onlineinsuranceclaim.exceptions;

import com.onlineinsuranceclaim.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class LoginExceptionHandler {

    public static final String message = "Exception While Processing Request";

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ResponseDTO> LoginException(LoginException exception) {
        ResponseDTO responseDTO = new ResponseDTO(message,exception.getMessage());
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
