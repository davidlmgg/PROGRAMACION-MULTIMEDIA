package com.example.loginandroid_29_09_2023.beans;

import java.io.Serializable;

public class User implements Serializable {
    private String idusu;
    private String email;
    private String password;

    public User(String idusu, String email, String password) {
        this.idusu = idusu;
        this.email = email;
        this.password = password;
    }

    public String getIdusu() {
        return idusu;
    }
    public void setIdusu(String idusu) {
        this.idusu = idusu;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
