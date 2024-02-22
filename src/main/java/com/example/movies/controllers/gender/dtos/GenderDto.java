package com.example.movies.controllers.gender.dtos;

import com.example.movies.models.gender.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public class GenderDto {
    public GenderDto(){
    }

    private Long id;

    @NotEmpty(message = "Campo obligatorio")
    @Size(max = 30, message = "El genero debe tener máximo 30 caracteres")
    private String gender;

    public Gender castToGender() {
        return new Gender(getId(), getGender(), null);
    }
}
