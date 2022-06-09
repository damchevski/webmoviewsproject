package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document("movies")
public class UserMovies {

    // Triple store

    // damchevski likes dbpedia..#titanic
    // titanic is movieReference
    // but info for titanic will be fetched from dbpedia
    // with sparql

    public String username;
    public String relation;
    public String movieReference;

    public UserMovies(String username, String relation, String movieReference){
        this.username = username;
        this.relation = relation;
        this.movieReference = movieReference;
    }
}
