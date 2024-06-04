package com.example.cinema.services;

import com.example.cinema.models.Movies;
import com.example.cinema.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MoviesRepository moviesRepo;

    public List<Movies> getAllMovies() {
        return moviesRepo.findAll();
    }

    public Optional<Movies> getMovieByID(int id) {
        return  moviesRepo.findById(id);
    }

    public Movies addMovie(Movies movie) {
        return moviesRepo.save(movie);
    }

    public void updateMovie(int id, Movies movie) {

        Movies movieToUpdate = moviesRepo.getById(id);

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setRating(movie.getRating());
        movieToUpdate.setDuration(movie.getDuration());
    }

    public void deleteMovie(int id) {
        moviesRepo.deleteById(id);
    }
}
