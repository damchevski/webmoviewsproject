package com.example.demo.services;

import com.example.demo.model.Movie;
import com.example.demo.model.UserMovies;
import com.example.demo.repository.MoviesRepository;
import org.apache.catalina.User;
import org.apache.jena.base.Sys;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.riot.RDFParser;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.util.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

@Service
public class MovieService  implements  IMovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<Movie> GetAllMoviesForUser(String username) {
        List<UserMovies> allRelations = this.moviesRepository.findByUsername(username);

        List<Movie> moviesForReturn = new LinkedList<>();

        for (var movieRelation : allRelations) {
            moviesForReturn.add(findMovieInfo(movieRelation.movieReference));
        }

        return moviesForReturn;
    }

    @Override
    public Movie findMovieInfo(String movieReference) {
        String movieUri = "http://dbpedia.org/data/" + movieReference + ".rdf";

        FileManager fManager = FileManager.get();
        fManager.addLocatorURL();
        Model model = fManager.loadModel(movieUri);

        Resource movieResource =
                model.getResource("http://dbpedia.org/resource/" + movieReference);

        Property directorProperty =
                model.getProperty("http://dbpedia.org/property/director");

        Resource director = (Resource) movieResource
                .getProperty(directorProperty)
                .getObject();

        String movieName = movieResource.getProperty(FOAF.name)
                .getLiteral()
                .toString();

        Model modelForDirector = model.read(director
                .toString()
                .replace("resource", "data"));

        String directorName = modelForDirector
                .getResource(director.toString())
                .getProperty(FOAF.name)
                .getLiteral().toString();

        Movie m = new Movie(movieReference, movieName, directorName);

        return m;
    }

    @Override
    public UserMovies addUserMovie(String username, String movieName) {
        return moviesRepository.save(new UserMovies(username, "likes", movieName));
    }
}
