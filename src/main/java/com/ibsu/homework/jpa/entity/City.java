package com.ibsu.homework.jpa.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "city")
public class City {
    @Id
    @SequenceGenerator(sequenceName = "city_id_seq", name = "city_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "city_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city", nullable = false)
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;


    public City() {}

    public City(Integer cityId, String city, Country countryId, Timestamp lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.country = countryId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
