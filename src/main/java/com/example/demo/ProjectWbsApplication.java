package com.example.demo;

import com.example.demo.model.UserMovies;
import com.example.demo.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProjectWbsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWbsApplication.class, args);
	}

	@Autowired
	MoviesRepository moviesRepository;


	@Override
	public void run(String... args) throws Exception {
		moviesRepository.save(new UserMovies("damchevski","likes","titanic"));
	}
}
