package com.ibsu.homework.jpa.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @SequenceGenerator(sequenceName = "film_id_seq", name = "film_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "film_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "film_id")
    private Integer filmId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    private Integer releaseYear;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @Column(name = "rental_duration", nullable = false)
    private Integer rentalDuration;
    @Column(name = "rental_rate", nullable = false)
    private Double rentalRate;
    @Column(name = "length")
    private Integer length;
    @Column(name = "replacement_cost", nullable = false)
    private Double replacementCost;
    @Column(name = "rating")
    private String rating;
    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;
    @Column(name = "special_features")
    private String specialFeatures;

    public Film() {
    }

    public Film(Integer filmId, String title, String description, Integer releaseYear, Language language, Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating, LocalDate lastUpdate, String specialFeatures) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.language = language;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.lastUpdate = lastUpdate;
        this.specialFeatures = specialFeatures;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
}
