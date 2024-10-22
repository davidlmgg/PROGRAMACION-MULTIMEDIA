package com.example.loginandroid_29_09_2023.login_user.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;

public class LoginUserM extends AppCompatActivity implements ContractLoginUser.View {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private LoginUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);
        presenter = new LoginUserPresenter(this);
        initComponents();
    }

    private void initComponents() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    User user = new User("", email, password);
                    presenter.login(user);
                } else {
                    Toast.makeText(LoginUserM.this, "Porfavor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void successLogin(User user) {
        Toast.makeText(this, "Bienvenido " + user.getEmail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}
