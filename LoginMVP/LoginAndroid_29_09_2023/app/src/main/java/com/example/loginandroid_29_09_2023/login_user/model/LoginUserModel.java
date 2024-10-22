package com.example.loginandroid_29_09_2023.login_user.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.model.data.MyData;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiResponse;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.LoginParams;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements ContractLoginUser.Model {
     private static final String IP_BASE = "192.168.104.80:3000";
    private LoginUserPresenter presenter;

    public LoginUserModel(LoginUserPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(User user, final OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "").create(ApiService.class);

        LoginParams loginParams = new LoginParams(user.getEmail(), user.getPassword());

        Call<ApiResponse> call = apiService.login(loginParams);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse apiResponse = response.body();
                    User loggedUser = apiResponse.getUser();
                    onLoginUserListener.onFinished(loggedUser);
                } else {
                    onLoginUserListener.onFailure("Login failed: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("Response Error", "Error: " + t.getMessage());
                onLoginUserListener.onFailure("Network error: " + t.getMessage());
            }
        });
    }
    }

