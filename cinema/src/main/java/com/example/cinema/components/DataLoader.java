package com.example.cinema.components;

import com.example.cinema.models.Movies;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Movies _movie1 = new Movies("Top Gun: Maverick", "12", 131);
        Movies _movie2 = new Movies("Interstellar", "12", 169);
        Movies _movie3 = new Movies("The Wold of Wall Street", "18", 190);
        Movies _movie4 = new Movies("The Fifth Element", "PG", 126);

        movieService.addMovie(_movie1);
        movieService.addMovie(_movie2);
        movieService.addMovie(_movie3);
        movieService.addMovie(_movie4);

    }
}