package com.pet_adoption.service;

import com.pet_adoption.entitites.Shelter;
import com.pet_adoption.exception.ShelterNotFoundException;
import com.pet_adoption.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public List<Shelter> getAllShelters() {
        return shelterRepository.findAll();
    }

    public Shelter getShelterById(Long id) {
        return shelterRepository.findById(id).orElseThrow(() -> new ShelterNotFoundException("Shelter not found with id " + id));
    }

    public Shelter createShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    public Shelter updateShelter(Shelter shelter) {
        Shelter existingShelter = getShelterById(shelter.getId());
        existingShelter.setName(shelter.getName());
        existingShelter.setAddress(shelter.getAddress());
        return shelterRepository.save(existingShelter);
    }

    public void deleteShelter(Long id) {
        shelterRepository.deleteById(id);
    }

    public List<Shelter> searchSheltersByName(String name) {
        return shelterRepository.findByNameContaining(name);
    }
}
