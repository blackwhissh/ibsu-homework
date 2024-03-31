package com.ibsu.homework.jpa.repository;

import com.ibsu.homework.jpa.dto.FilmDTO;
import com.ibsu.homework.jpa.entity.Film;
import com.ibsu.homework.jpa.entity.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Page<FilmDTO> findFilmsByTitleOrDescriptionOrReleaseYearAfterOrLanguage(String title,
                                                                       String description,
                                                                       Integer releaseYear,
                                                                       Language language,
                                                                       Pageable pageable);
}
