package com.onlineinsuranceclaim.model;

import com.onlineinsuranceclaim.dto.RegistrationDTO;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_details")
public @Data class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String roleCode;

    public UserData() { }

    @OneToMany(cascade = CascadeType.ALL)
    private List<PolicyData> policyDataList;

    public UserData(RegistrationDTO registrationDTO) {
        this.userName = registrationDTO.getUserName();
        this.password = registrationDTO.getPassword();
        this.firstName = registrationDTO.getFirstName();
        this.lastName = registrationDTO.getLastName();
        this.phone = registrationDTO.getPhone();
        this.email = registrationDTO.getEmail();
        this.roleCode = registrationDTO.getRoleCode();
    }
}
