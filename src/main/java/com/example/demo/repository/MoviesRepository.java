package com.example.demo.repository;

import com.example.demo.model.UserMovies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MoviesRepository
        extends MongoRepository<UserMovies, Integer> {

    @Query("{username:'?0'}")
    List<UserMovies> findByUsername(String username);
}
