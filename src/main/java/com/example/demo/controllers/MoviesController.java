package com.example.demo.controllers;

import com.example.demo.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String indexMovies(){
        //finish

        //this is for example
        var allMovies = this.movieService.GetAllMoviesForUser("damchevski");

        return "movies/movies.html";
    }

    //First function:
    //here we need method with param movieReference and userName
    //then we will call service -> repo and save to store

    //Second function:
    //From the view user will send username
    //Then we will call service and find all movies
    //in store linked with this username
    //then we will send request to dbpedia for all
    //movies, create Movie instance and send to view

    //..
}
