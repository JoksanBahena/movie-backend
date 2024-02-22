package com.example.movies.models.movie;

import com.example.movies.models.gender.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "director", nullable = false, length = 255)
    private String director;

    @Column(name = "duration", nullable = false, length = 20)
    private String duration;

    @Column(name = "publication_date", nullable = false)
    private Date publication_date;

    @ManyToOne
    private Gender gender;
}
