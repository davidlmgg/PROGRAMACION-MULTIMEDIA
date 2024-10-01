package com.svalero.themoviedb_001.json_mapper;

import java.util.List;
public class MovieResponse {
    // URL: https://api.themoviedb.org/3/movie/popular?api_key=184fac86ecc0ed1b819e43621d5ecb63
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
