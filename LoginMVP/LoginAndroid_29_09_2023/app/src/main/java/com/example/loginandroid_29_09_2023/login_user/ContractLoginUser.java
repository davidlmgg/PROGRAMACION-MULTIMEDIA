package com.example.loginandroid_29_09_2023.login_user;

import com.example.loginandroid_29_09_2023.beans.User;

public interface ContractLoginUser {
    public interface View{
        public void successLogin(User user);
        void failureLogin(String err);
    }
    public interface Presenter{
        void login(User user);
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(User user);
            void onFailure(String err);
        }
        void loginAPI(User user, OnLoginUserListener onLoginUserListener);
    }
}
