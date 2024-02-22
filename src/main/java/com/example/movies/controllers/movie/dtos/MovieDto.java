package com.example.movies.controllers.movie.dtos;

import com.example.movies.models.gender.Gender;
import com.example.movies.models.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class MovieDto {
    public MovieDto() {
    }

    private Long id;

    @NotEmpty(message = "Campo obligatorio")
    @Size(max = 100, message = "El nombre debe tener máximo de 100 caracteres")
    private String name;

    @NotEmpty(message = "Campo obligatorio")
    @Size(max = 60, message = "El nombre del director debe tener máximo 60 caracteres")
    private String director;

    @NotEmpty(message = "Campo obligatorio")
    @Size(max = 10, message = "Duración debe llevar el formato HH:MMmin")
    private String duration;

    @NotEmpty(message = "Campo obligatorio")
    private Date publication_date;

    private Gender gender;

    public Movie castToMovie() {
        return new Movie(getId(), getName(), getDirector(), getDuration(), getPublication_date(), null);
    }
}
