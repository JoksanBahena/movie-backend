package com.example.movies.services;

import com.example.movies.models.movie.Movie;
import com.example.movies.models.movie.MovieRepository;
import com.example.movies.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Movie>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "ok"
        );
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<Movie> insert(Movie movie) {
        return new CustomResponse<>(
                this.repository.saveAndFlush(movie),
                false,
                200,
                "Pelicula registrada correctamente"
        );
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<String> update(Movie movie) {
        if (!this.repository.existsById(movie.getId())) {
            return new CustomResponse<>(
                    null,
                    true,
                    404,
                    "No existe la pelicula"
            );
        }

        this.repository.saveAndFlush(movie);
        return new CustomResponse<>(
                null,
                false,
                200,
                "Pelicula actualizada correctamente"
);
    }
}
