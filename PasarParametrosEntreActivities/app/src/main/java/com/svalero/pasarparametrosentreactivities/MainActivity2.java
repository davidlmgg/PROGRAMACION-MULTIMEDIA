package com.svalero.pasarparametrosentreactivities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.svalero.pantalla1activity.R;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtUser = (TextView) findViewById(R.id.txtUserPantalla2);

        Bundle variables = getIntent().getExtras();
        String user = variables.getString("USUARIO");

        txtUser.setText(user);
    }
}