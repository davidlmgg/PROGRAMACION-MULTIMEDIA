package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.beans.User;

import java.util.ArrayList;

public class ApiResponse {
    private String message;
    private User user; // Cambiado a un solo usuario

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
