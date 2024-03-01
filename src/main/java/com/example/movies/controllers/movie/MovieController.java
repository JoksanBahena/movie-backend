package com.example.movies.controllers.movie;

import com.example.movies.controllers.movie.dtos.MovieDto;
import com.example.movies.models.movie.Movie;
import com.example.movies.services.MovieService;
import com.example.movies.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = {"*"})
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Movie>>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CustomResponse<Movie>> getMovieByName(@PathVariable String name) {
        return new ResponseEntity<>(this.service.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/director/{director}")
    public ResponseEntity<CustomResponse<Movie>> getMovieByDirector(@PathVariable String director) {
        return new ResponseEntity<>(this.service.getByDirector(director), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Movie>> getMovieById(@PathVariable long id) {
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Movie>> insert(@Valid @RequestBody MovieDto movieDto) {
        System.out.println(movieDto.getName());
        System.out.println(movieDto.getDirector());
        System.out.println(movieDto.getDuration());
        System.out.println(movieDto.getPublication_date());
        System.out.println(movieDto.getGender().getGender());
        return new ResponseEntity<>(this.service.insert(movieDto.castToMovie()), HttpStatus.CREATED);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<CustomResponse<String>> update(@Valid @PathVariable long id, @RequestBody MovieDto movieDto) {
        movieDto.setId(id);
        return new ResponseEntity<>(this.service.update(movieDto.castToMovie()), HttpStatus.OK);
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<CustomResponse<String>> delete(@PathVariable long id) {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }
}
