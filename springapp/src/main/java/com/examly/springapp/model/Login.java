package com.examly.springapp.model;

import javax.persistence.*;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LoginId;
    private String username;
    private String password;
    public Login(){
        //TODO document why the constructor is empty
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    public Long getLoginId() {
        return LoginId;
    }

    public void setLoginId(Long loginId) {
        LoginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

