package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public @ToString class CreateProfileDTO {

    private String userName;
    private String password;
    private String roleID;
}
