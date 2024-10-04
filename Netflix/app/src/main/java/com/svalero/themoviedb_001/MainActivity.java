package com.svalero.themoviedb_001;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.themoviedb_001.service.MovieService;

public class MainActivity extends AppCompatActivity {

    private MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieService = new MovieService(this); // Inicializamos el servicio

        Button btnPopular = findViewById(R.id.btn_popular);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnDetails = findViewById(R.id.btn_details);

        btnPopular.setOnClickListener(v -> movieService.getPopularMovies());

        btnSearch.setOnClickListener(v -> movieService.searchMovies("titanic"));

        btnDetails.setOnClickListener(v -> movieService.getMovieDetails(550)); // ID de "Fight Club"
    }
}
