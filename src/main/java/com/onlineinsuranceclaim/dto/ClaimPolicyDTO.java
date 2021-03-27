package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public @ToString class ClaimPolicyDTO {
    private Long claimNumber;
    private String claimReason;
    private String accidentLocation;
    private String accidentCity;
    private String accidentState;
    private int accidentZip;
    private String claimType;
    private Long policyNumber;

}
