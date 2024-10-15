package com.svalero.mvp.adapter;

import android.view.View;


import com.svalero.mvp.beans.User;

import java.util.ArrayList;

public class AdapterUser {

    private ArrayList<User> lstUsers;
    private View.OnClickListener listener;

    public AdapterUser(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }
}
