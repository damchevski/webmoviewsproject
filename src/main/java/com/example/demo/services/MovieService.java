package com.example.demo.services;

import com.example.demo.model.Movie;
import com.example.demo.model.UserMovies;
import com.example.demo.repository.MoviesRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService  implements  IMovieService{

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<UserMovies> GetAllMoviesForUser(String username) {
        List<UserMovies> allRelations = this.moviesRepository.findByUsername(username);

        return allRelations;
    }

    @Override
    public Movie findMovieInfo(String movieReference) {
        //include libraries and make
        //sparql request to dbpedia with this
        //movieReference than from result
        //read needed properties and create Move instance
        //and send it back

        String query = "SELECT..";

        return null;
    }
}
