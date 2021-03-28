package com.onlineinsuranceclaim.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public  @ToString class ReportGenerationDTO {

    private Long claimNumber;
    private String claimReason;
    private String claimType;
    private String details;

}
