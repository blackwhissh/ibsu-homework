package com.ibsu.homework.jpa.controller;

import com.ibsu.homework.jpa.dto.FilmDTO;
import com.ibsu.homework.jpa.entity.Language;
import com.ibsu.homework.jpa.repository.LanguageRepository;
import com.ibsu.homework.jpa.service.FilmService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/film", produces = {"application/json"})
public class FilmController {
    private final FilmService filmService;
    private final LanguageRepository languageRepository;

    public FilmController(FilmService filmService, LanguageRepository languageRepository) {
        this.filmService = filmService;
        this.languageRepository = languageRepository;
    }

    @GetMapping("/search")
    public List<FilmDTO> search(@RequestParam(name = "title", required = false) String title,
                                @RequestParam(name = "description", required = false) String description,
                                @RequestParam(name = "year", required = false) Integer releaseYear,
                                @RequestParam(name = "language", required = false) String language,
                                @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        int size = 10;
        Language language1 = null;
        if (language != null) {
            language1 = languageRepository.findByNameIgnoreCase(language).orElseThrow(InputMismatchException::new);
        }
        Pageable pageable = PageRequest.of(page, size);
        return filmService.searchFilms(title, description, releaseYear, language1, pageable).toList();
    }
}
