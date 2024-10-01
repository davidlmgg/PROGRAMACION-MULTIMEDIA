package com.svalero.themoviedb_001;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.svalero.themoviedb_001.json_mapper.Movie;
import com.svalero.themoviedb_001.json_mapper.MovieResponse;
import com.svalero.themoviedb_001.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "184fac86ecc0ed1b819e43621d5ecb63";
    private final String LANGUAGE = "es-ES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPopular = findViewById(R.id.btn_popular);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnDetails = findViewById(R.id.btn_details);

        btnPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPopularMovies();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchMovies("titanic");
            }
        });

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMovieDetails(550); // ID de "Fight Club"
            }
        });
    }

    private void getPopularMovies() {
        Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies(API_KEY, LANGUAGE, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(MainActivity.this, "Películas Populares Cargadas: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error al obtener las películas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void searchMovies(String query) {
        Call<MovieResponse> call = RetrofitClient.getInstance().searchMovies(API_KEY, LANGUAGE, query, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(MainActivity.this, "Búsqueda completada: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error en la búsqueda", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMovieDetails(int movieId) {
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(movieId, API_KEY, LANGUAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body(); // Es un solo objeto, no una lista
                    if (movie != null) {
                        Toast.makeText(MainActivity.this, "Detalles de la Película: " + movie.getTitle() + "\nResumen: " + movie.getOverview(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "No se encontraron detalles para la película", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error al obtener los detalles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }

}