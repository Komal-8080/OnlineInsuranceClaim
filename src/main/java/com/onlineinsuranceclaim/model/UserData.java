package com.onlineinsuranceclaim.model;

import com.onlineinsuranceclaim.dto.RegistrationDTO;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user_login")
public @Data class UserData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userid;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;



    public UserData(String userName, String password, String firstName, String lastName, String phone) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public UserData() {

    }
}
