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

    public UserData() {

    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "policy_details",joinColumns = @JoinColumn(name = "userId"))
    private List<PolicyData> policyDataList;

    public UserData(String userName, String password, String firstName, String lastName, String phone) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
}
