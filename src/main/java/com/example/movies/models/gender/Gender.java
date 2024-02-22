package com.example.movies.models.gender;

import com.example.movies.models.movie.Movie;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Table(name = "genders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gender", nullable = false, length = 30)
    private String gender;

    @OneToMany(mappedBy = "gender")
    private Set<Movie> movies;
}
