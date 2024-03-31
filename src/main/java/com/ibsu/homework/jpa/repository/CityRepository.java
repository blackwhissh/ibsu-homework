package com.ibsu.homework.jpa.repository;

import com.ibsu.homework.jpa.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findAllByCity(String city);
}
