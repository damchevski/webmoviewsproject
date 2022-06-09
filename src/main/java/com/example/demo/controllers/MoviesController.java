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

    @GetMapping("/getMovies")
    public String getIndex(){

        return "movies/getMovies.html";
    }


    @PostMapping("/getMovies")
    public String indexMovies(@RequestParam String username, Model model){
        //finish

        //this is for example
        var allMovies = this.movieService.GetAllMoviesForUser(username);
        model.addAttribute("allMovies", allMovies);

        return "movies/movies.html";
    }

    //pocetna so 2 kopcinja
    //edno list for user
    //i use edno add for user koj ke nosi na novovo
    //i na niv back koj ke nosat na pocetna
    //i na movies.html back so ke nosi na pocetna

    //nov povik koj sto vrakja view so 2 polinja
    //edno za username edno za imeto na filmot

    //post za povikot odozgore
    //prais vo service funkcija i kreiras
    //tamu usermovies so relacija likes
    //i posle samo vo repo .Save



}
