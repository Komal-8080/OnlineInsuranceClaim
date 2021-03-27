//package com.onlineinsuranceclaim.model;
//
//import com.onlineinsuranceclaim.dto.ReportGenerationDTO;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class ReportGeneration {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "claimNumber")
//    private Long claimNumber;
//    private String claimReason;
//    private String claimType;
//    private String details;
//
//    public ReportGeneration(ReportGenerationDTO reportGenerationDTO){
//        this.claimNumber = reportGenerationDTO.getClaimNumber();
//        this.claimReason = reportGenerationDTO.getClaimReason();
//        this.claimType = reportGenerationDTO.getClaimType();
//        this.details = reportGenerationDTO.getDetails();
//    }
//}
