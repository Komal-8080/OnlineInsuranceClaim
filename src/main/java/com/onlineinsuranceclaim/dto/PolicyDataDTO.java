package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.*;

@Getter
@Setter
public @ToString class PolicyDataDTO {

    private Long policyNumber;
    private Long accountNumber;
    private double premiumAmount;
}
