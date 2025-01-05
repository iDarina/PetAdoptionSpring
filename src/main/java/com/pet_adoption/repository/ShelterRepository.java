package com.pet_adoption.repository;

import com.pet_adoption.entitites.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    List<Shelter> findByNameContaining(String name);
}
