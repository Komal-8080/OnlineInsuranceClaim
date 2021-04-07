package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.*;

@Getter
@Setter
public @ToString class PolicyDataDTO {

    @Min(value = 100000, message = "Policy Number must have atleast 6 digits")
    private Long policyNumber;

    @Min(value = 100000, message = "Account Number must have atleast 6 digits")
    private Long accountNumber;

    private double premiumAmount;
}
