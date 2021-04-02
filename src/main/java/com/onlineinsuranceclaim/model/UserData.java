package com.onlineinsuranceclaim.model;

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

    public UserData() {

    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "policyNumber")
    private List<PolicyData> policyDataList;

    public UserData(String userName, String password, String firstName, String lastName, String phone, String email,String roleCode) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.roleCode = roleCode;
    }
}
