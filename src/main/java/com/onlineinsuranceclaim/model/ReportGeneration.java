package com.onlineinsuranceclaim.model;

import com.onlineinsuranceclaim.dto.ReportGenerationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public @Data class ReportGeneration {

    @Id
    @Column(name = "claimNumber")
    private Long claimNumber;
    private String claimReason;
    private String claimType;
    private String details;
    private Long id;

    public ReportGeneration(ReportGenerationDTO reportGenerationDTO){
        this.claimNumber = reportGenerationDTO.getClaimNumber();
        this.claimReason = reportGenerationDTO.getClaimReason();
        this.claimType = reportGenerationDTO.getClaimType();
        this.details = reportGenerationDTO.getDetails();
    }
}
