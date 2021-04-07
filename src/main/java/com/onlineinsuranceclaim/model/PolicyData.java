package com.onlineinsuranceclaim.model;

import com.onlineinsuranceclaim.dto.PolicyDataDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Entity
public @Data class PolicyData {

    @Id
    @Column(name = "policyNumber")
    private Long policyNumber;
    private Long accountNumber;
    private double premiumAmount;
    private Long userId;


    @OneToOne(cascade = CascadeType.ALL)
    private ClaimPolicy claimPolicy;

    public PolicyData(PolicyDataDTO policyDataDTO) {
        this.policyNumber = policyDataDTO.getPolicyNumber();
        this.accountNumber= policyDataDTO.getAccountNumber();
        this.premiumAmount = policyDataDTO.getPremiumAmount();
    }

}