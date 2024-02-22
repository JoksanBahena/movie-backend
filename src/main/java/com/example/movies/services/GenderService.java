package com.example.movies.services;

import com.example.movies.models.gender.Gender;
import com.example.movies.models.gender.GenderRepository;
import com.example.movies.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenderService {
    @Autowired
    private GenderRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Gender>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "ok"
        );
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<Gender> insert(Gender gender) {
        return new CustomResponse<>(
                this.repository.saveAndFlush(gender),
                false,
                200,
                "Genero se registro correctamente"
        );
    }
}
