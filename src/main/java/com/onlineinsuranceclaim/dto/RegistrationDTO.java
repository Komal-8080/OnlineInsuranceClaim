package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public @ToString class RegistrationDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "UserName must start with uppercase and must have more then three characters")
    private String userName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}", message = "Password must be 8 characters,one uppercase,one lowercase,aleast one number and one special character")
    private String password;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "FirstName must start with uppercase and must have more then three characters")
    private String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "LastName must start with uppercase and must have more then three characters")
    private String lastName;

    @Pattern(regexp = "^([+][9][1]|[9][1]){0,1}([0-9]{1}[0-9]{9})$", message = "Invalid Phone Number")
    private String phone;

    @Pattern(regexp = "^([a-zA-a0-9\\.\\-\\+]+)@([a-zA-Z0-9\\.]{1,5})([a-zA-Z\\.]+){1,3}([a-zA-Z]{1,3})$", message = "Invalid Email Id")
    private String email;

    @Pattern(regexp = "Insured|ClaimHandler|ClaimAdjuster", message = "Role Code needs to be either Insured or ClaimHandler or ClaimAdjuster")
    private String roleCode;

}
