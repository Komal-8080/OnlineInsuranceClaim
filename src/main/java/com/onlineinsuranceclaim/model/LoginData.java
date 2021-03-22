package com.onlineinsuranceclaim.model;

import com.onlineinsuranceclaim.dto.LoginDTO;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user_login")
public @Data class LoginData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userid;
    private String userName;
    private String password;

    public LoginData() {

    }

    public LoginData(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
