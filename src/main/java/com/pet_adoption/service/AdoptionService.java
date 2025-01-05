package com.pet_adoption.service;

import com.pet_adoption.entitites.Adoption;
import com.pet_adoption.exception.AdoptionNotFoundException;
import com.pet_adoption.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionService {
    private final AdoptionRepository adoptionRepository;

    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository) {
        this.adoptionRepository = adoptionRepository;
    }

    public List<Adoption> getAllAdoptions() {
        return adoptionRepository.findAll();
    }

    public Adoption getAdoptionById(Long id) {
        return adoptionRepository.findById(id).orElseThrow(() -> new AdoptionNotFoundException("Adoption not found with id " + id));
    }

    public Adoption createAdoption(Adoption adoption) {
        return adoptionRepository.save(adoption);
    }

    public Adoption updateAdoption(Adoption adoption) {
        Adoption existingAdoption = getAdoptionById(adoption.getId());
        existingAdoption.setAdopterName(adoption.getAdopterName());
        existingAdoption.setAdopterEmail(adoption.getAdopterEmail());
        existingAdoption.setPet(adoption.getPet());
        return adoptionRepository.save(existingAdoption);
    }

    public void deleteAdoption(Long id) {
        adoptionRepository.deleteById(id);
    }

    public List<Adoption> searchAdoptionsByAdopterName(String adopterName) {
        return adoptionRepository.findByAdopterNameContaining(adopterName);
    }
}
