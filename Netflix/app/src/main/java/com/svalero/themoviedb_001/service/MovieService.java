package com.svalero.themoviedb_001.service;

import android.content.Context;
import android.widget.Toast;

import com.svalero.themoviedb_001.json_mapper.Movie;
import com.svalero.themoviedb_001.json_mapper.MovieResponse;
import com.svalero.themoviedb_001.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieService {

    private final String API_KEY = "184fac86ecc0ed1b819e43621d5ecb63";
    private final String LANGUAGE = "es-ES";
    private Context context;

    public MovieService(Context context) {
        this.context = context;
    }

    public void getPopularMovies() {
        Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies(API_KEY, LANGUAGE, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(context, "Películas Populares Cargadas: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Error al obtener las películas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void searchMovies(String query) {
        Call<MovieResponse> call = RetrofitClient.getInstance().searchMovies(API_KEY, LANGUAGE, query, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(context, "Búsqueda completada: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Error en la búsqueda", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getMovieDetails(int movieId) {
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(movieId, API_KEY, LANGUAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    if (movie != null) {
                        Toast.makeText(context, "Detalles de la Película: " + movie.getTitle() + "\nResumen: " + movie.getOverview(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "No se encontraron detalles para la película", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Error al obtener los detalles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(context, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
