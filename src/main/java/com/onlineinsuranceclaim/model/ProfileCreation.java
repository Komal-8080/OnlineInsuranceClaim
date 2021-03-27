//package com.onlineinsuranceclaim.model;
//
//import com.onlineinsuranceclaim.dto.ProfileCreationDTO;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//
//
//@NoArgsConstructor
////@Entity
////@Table(name = "profileDetails")
//public class ProfileCreation {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "userName")
//    private String userName;
//    private String password;
//    private String roleId;
//
//    public ProfileCreation(ProfileCreationDTO profileCreationDTO) {
//        this.userName = profileCreationDTO.getUserName();
//        this.password = profileCreationDTO.getPassword();
//        this.roleId = profileCreationDTO.getRoleID();
//    }
//}
