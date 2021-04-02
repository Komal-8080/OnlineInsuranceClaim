package com.onlineinsuranceclaim.model;

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

}
