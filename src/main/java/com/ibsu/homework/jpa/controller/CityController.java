package com.ibsu.homework.jpa.controller;

import com.ibsu.homework.jpa.dto.CityDTO;
import com.ibsu.homework.jpa.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/city", produces = {"application/json"})
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/{city}")
    public List<CityDTO> findByCity(@PathVariable("city") String city){
        return cityService.findByCity(city);
    }
}
