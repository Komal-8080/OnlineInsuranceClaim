package com.onlineinsuranceclaim.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public @Data class ReportGeneration {

    @Id
    @Column(name = "claimNumber")
    private Long claimNumber;
    private String claimReason;
    private String claimType;

    @OneToOne(cascade = CascadeType.ALL)
    private UserData details;

}
