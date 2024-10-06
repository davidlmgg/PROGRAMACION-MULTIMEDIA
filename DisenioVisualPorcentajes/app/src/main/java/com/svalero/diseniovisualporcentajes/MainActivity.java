package com.svalero.diseniovisualporcentajes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button miBotonA;
    private Button miBotonB;
    private Button miBotonC;
    private Button miBotonD;
    private Button miBotonE;
    private Button miBotonF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // InicializarComponentes
        inicializarComponentes();
        // Fin

        miBotonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botón A", Toast.LENGTH_SHORT).show();
            }
        });

        miBotonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botón B", Toast.LENGTH_SHORT).show();
            }
        });

        miBotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botón C", Toast.LENGTH_SHORT).show();
            }
        });

        miBotonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botón D", Toast.LENGTH_SHORT).show();
            }
        });

        miBotonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botón E", Toast.LENGTH_SHORT).show();
            }
        });

        miBotonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botón F", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void inicializarComponentes() {
        miBotonA = (Button) findViewById(R.id.btnA);
        miBotonB = (Button) findViewById(R.id.btnB);
        miBotonC = (Button) findViewById(R.id.btnC);
        miBotonD = (Button) findViewById(R.id.btnD);
        miBotonE = (Button) findViewById(R.id.btnE);
        miBotonF = (Button) findViewById(R.id.btnF);
    }
}