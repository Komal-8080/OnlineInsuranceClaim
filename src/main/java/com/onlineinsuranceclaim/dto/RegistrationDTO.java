package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public @ToString class RegistrationDTO {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;

}
