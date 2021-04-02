package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.*;

@Getter
@Setter
public @ToString class PolicyDataDTO {

    @NotNull(message = "Invalid Policy Number")
    private Long policyNumber;

    @NotNull(message = "Invalid Account Number")
    private Long accountNumber;

    @NotNull(message = "Premium Amount cannot be empty")
    private double premiumAmount;
}
