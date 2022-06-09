package com.example.demo.model;

public class Movie {

    //Don't save in DB, fetch from dbpedia

    public String movieReference;
    public String name;
    public String author;

    //..

    public Movie(String movieReference, String name, String author){
        this.movieReference = movieReference;
        this.name = name;
        this.author = author;
    }

    public String getMovieReference() {
        return movieReference;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
