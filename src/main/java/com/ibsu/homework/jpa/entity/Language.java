package com.ibsu.homework.jpa.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @SequenceGenerator(name = "language_id_seq", sequenceName = "language_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "language_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "language_id")
    private Integer languageId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public Language() {
    }

    public Language(Integer languageId, String name, Timestamp lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
