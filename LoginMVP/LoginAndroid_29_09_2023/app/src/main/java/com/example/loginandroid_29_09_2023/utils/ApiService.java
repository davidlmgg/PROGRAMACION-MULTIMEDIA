package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.beans.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("/login")
    Call<ApiResponse> login(@Body LoginParams loginParams);
}
