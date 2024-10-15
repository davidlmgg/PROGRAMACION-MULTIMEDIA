package com.svalero.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.mvp.adapter.AdapterUser;
import com.svalero.mvp.beans.User;
import com.svalero.mvp.login_user.LoginUserContract;
import com.svalero.mvp.login_user.LoginUserPresenter;

import java.util.ArrayList;

public class MainActivity
        extends AppCompatActivity
        implements LoginUserContract.View {

    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;
    private LoginUserPresenter loginUserPresenter;
    private ArrayList<User> lstUsers;
    private String emailenter;
    private String passwordenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Instanciar Presenter*/
        loginUserPresenter = new LoginUserPresenter(this);
        // lstUsersPresenter.getUsers();
        /*Fin*/
        /*Declaramos objetos del layout*/
        initComponents();
        /*Fin*/
        /*Cargamos SharedPreferences*/
        // cargarPreferencias();
        /*Fin*/
        /*Accion al pulsar el boton Login*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailenter=edtUser.getText().toString();
                passwordenter=edtPass.getText().toString();
                User usuario = new User();
                usuario.setEmail(emailenter);
                usuario.setPassword(passwordenter);
                loginUserPresenter.getUser(usuario);
                // comprobarFormato(emailenter,passwordenter);

            }
        });
    }
    // Sugerencia: Butterknife Android
    private void initComponents() {
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    /*Fin*/
    @Override
    public void sucessLogin(User usuario) {
        Toast.makeText(this, "Bienvenido=" + usuario.getNombre(), Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(getBaseContext(), ListaPeliculas.class);
        // startActivity(intent);
    }

    @Override
    public void failureLogin(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
