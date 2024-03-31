package com.ibsu.homework.jpa.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @SequenceGenerator(sequenceName = "country_id_seq", name = "country_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "country_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public Country() {}

    public Country(Integer countryId, String country, Timestamp lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
