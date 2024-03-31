package com.ibsu.homework.jpa.service;

import com.ibsu.homework.jpa.dto.FilmDTO;
import com.ibsu.homework.jpa.entity.Language;
import com.ibsu.homework.jpa.repository.FilmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    public Page<FilmDTO> searchFilms(String title, String description, Integer releaseYear,
                                     Language language, Pageable pageable){
        return filmRepository
                .findFilmsByTitleOrDescriptionOrReleaseYearAfterOrLanguage(title,description,releaseYear,language,pageable);
    }
}
