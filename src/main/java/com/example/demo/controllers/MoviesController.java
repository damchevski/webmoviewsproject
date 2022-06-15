package com.example.demo.controllers;

import com.example.demo.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getHomePage(){
        return "movies/index.html";
    }

    @GetMapping("/getMovies")
    public String getMovies(){

        return "movies/getMovies.html";
    }


    @PostMapping("/getMovies")
    public String showMovies(@RequestParam String username, Model model){
        var allMovies = this.movieService.GetAllMoviesForUser(username);
        model.addAttribute("allMovies", allMovies);

        return "movies/movies.html";
    }

    @GetMapping("/addUserMovie")
    public String addUserMovie() {
        return "movies/addUserMovie.html";
    }

    @PostMapping("/addUserMovie")
    public String saveUserMovie(@RequestParam String username, @RequestParam String movieName){
        movieService.addUserMovie(username, movieName);
        return "movies/index.html";
    }

}
