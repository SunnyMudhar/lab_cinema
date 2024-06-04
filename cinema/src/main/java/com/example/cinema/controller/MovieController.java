package com.example.cinema.controller;

import com.example.cinema.models.Movies;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movies> getMovieByID(@PathVariable int id) {

        Optional<Movies> movie = movieService.getMovieByID(id);

        return movie.map(movies -> new ResponseEntity<>(movies, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Movies> updateMovie(@PathVariable int id, @RequestBody Movies movie) {

        Optional<Movies> movieOpt = movieService.getMovieByID(id);

        if(movieOpt.isPresent()) {
            movieService.updateMovie(id, movie);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movies> deleteMovie(@PathVariable int id) {

        Optional<Movies> movieOpt = movieService.getMovieByID(id);

        if (movieOpt.isPresent()) {
            movieService.deleteMovie(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
