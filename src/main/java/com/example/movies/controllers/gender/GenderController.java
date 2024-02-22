package com.example.movies.controllers.gender;

import com.example.movies.controllers.gender.dtos.GenderDto;
import com.example.movies.models.gender.Gender;
import com.example.movies.services.GenderService;
import com.example.movies.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/genders")
@CrossOrigin(origins = {"*"})
public class GenderController {
    @Autowired
    private GenderService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Gender>>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Gender>> insert(@Valid @RequestBody GenderDto genderDto) {
        return new ResponseEntity<>(this.service.insert(genderDto.castToGender()), HttpStatus.CREATED);
    }
}
