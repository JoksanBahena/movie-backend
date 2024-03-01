package com.example.movies.models.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByName(String name);
    Optional<Movie> findByDirector(String director);
    boolean existsByName(String name);
    boolean existsByDirector(String director);


    @Query(
        value = "SELECT * FROM movies WHERE publication_date = :date_start AND publication_date = :date_end", nativeQuery = true
    )
    boolean findByPublication_date(@Param("date_start") String date_start, @Param("date_end") String date_end);

    @Query(
        value = "SELECT * FROM movies ORDER BY publication_date DESC", nativeQuery = true
    )
    boolean findByNameOrderByPublication_date(@Param("name") String name);
}
