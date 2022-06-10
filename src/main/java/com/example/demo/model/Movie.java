package com.example.demo.model;

public class Movie {

    //Don't save in DB, fetch from dbpedia

    public String movieReference;
    public String name;
    public String director;

    public Movie(String movieReference, String name, String director){
        this.movieReference = movieReference;
        this.name = name;
        this.director = director;
    }

    public String getMovieReference() {
        return movieReference;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
