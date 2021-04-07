package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public @ToString class ClaimPolicyDTO {

    @NotBlank(message = "Claim Reason cannot be empty")
    private String claimReason;

    @NotBlank(message = "Accident Location cannot be empty")
    private String accidentLocation;

    @NotBlank(message = "Accident City cannot be empty")
    private String accidentCity;

//    @NotBlank(message = "Accident State cannot be empty")
    private String accidentState;

//    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Invalid ZipCode")
    private int accidentZip;

//    @NotBlank(message = "Claim Type cannot be empty")
    private String claimType;
}
