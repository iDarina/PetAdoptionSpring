package com.pet_adoption.service;

import com.pet_adoption.entitites.Pet;
import com.pet_adoption.exception.PetNotFoundException;
import com.pet_adoption.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet not found with id " + id));
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Pet pet) {
        Pet existingPet = getPetById(pet.getId());
        existingPet.setName(pet.getName());
        existingPet.setBreed(pet.getBreed());
        existingPet.setAge(pet.getAge());
        return petRepository.save(existingPet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public List<Pet> searchPetsByName(String name) {
        return petRepository.findByNameContaining(name);
    }
}
