package com.example.demo.services;


import com.example.demo.model.Movie;
import com.example.demo.model.UserMovies;

import java.util.List;

public interface IMovieService {
    List<Movie> GetAllMoviesForUser(String username);
    Movie findMovieInfo(String movieReference);
}
