package com.onlineinsuranceclaim.model;

import com.onlineinsuranceclaim.dto.ClaimPolicyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public @Data class ClaimPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "claimNumber")
    private Long claimNumber;
    private Long policyNumber;
    private String claimReason;
    private String accidentLocation;
    private String accidentCity;
    private String accidentState;
    private int accidentZip;
    private String claimType;

    public ClaimPolicy(ClaimPolicyDTO claimPolicyDTO) {
        this.claimReason = claimPolicyDTO.getClaimReason();
        this.accidentLocation = claimPolicyDTO.getAccidentLocation();
        this.accidentCity = claimPolicyDTO.getAccidentCity();
        this.accidentState = claimPolicyDTO.getAccidentState();
        this.accidentZip = claimPolicyDTO.getAccidentZip();
        this.claimType = claimPolicyDTO.getClaimType();
    }

}
