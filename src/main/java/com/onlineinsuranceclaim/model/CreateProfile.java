package com.onlineinsuranceclaim.model;

import com.onlineinsuranceclaim.dto.CreateProfileDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "profileDetails")
public @Data class CreateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userName")
    private String userName;
    private String password;
    private String roleId;
    private Long id;

    public CreateProfile(CreateProfileDTO createProfileDTO) {
        this.userName = createProfileDTO.getUserName();
        this.password = createProfileDTO.getPassword();
        this.roleId = createProfileDTO.getRoleID();
    }
}
