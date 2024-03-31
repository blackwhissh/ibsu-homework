package com.ibsu.homework.jpa.service;

import com.ibsu.homework.jpa.dto.ActorDTO;
import com.ibsu.homework.jpa.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    public List<ActorDTO> findAll(){
        return actorRepository.findAll().stream()
                .map(actor -> new ActorDTO(actor.getFirstName(),actor.getLastName())).toList();
    }
}
