package com.example.demo.services;

import com.example.demo.model.Movie;
import com.example.demo.model.UserMovies;
import com.example.demo.repository.MoviesRepository;
import org.apache.catalina.User;
import org.apache.jena.base.Sys;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.riot.RDFParser;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

@Service
public class MovieService  implements  IMovieService{

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<Movie> GetAllMoviesForUser(String username) {
        List<UserMovies> allRelations = this.moviesRepository.findByUsername(username);

        List<Movie> moviesForReturn = new LinkedList<>();

        for (var movieRelation: allRelations) {
            moviesForReturn.add(findMovieInfo(movieRelation.movieReference));
        }

        return moviesForReturn;
    }

    @Override
    public Movie findMovieInfo(String movieReference) {
        String movieURI = "https://dbpedia.org/data/"+movieReference;

        Model model = ModelFactory.createDefaultModel();
        RDFParser.source(movieURI)
                .httpAccept("application/rdf+xml")
                .parse(model.getGraph());

        Resource movieResource =
                model.getResource(movieURI);

        System.out.println(movieResource.listProperties());

        Property directorProperty =
                model.getProperty("https://dbpedia.org/property/director");

        Resource director = (Resource) movieResource
                .getProperty(directorProperty)
                .getObject();



        return null;
    }
}
