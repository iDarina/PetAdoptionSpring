package com.pet_adoption.repository;

import com.pet_adoption.entitites.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    List<Adoption> findByAdopterNameContaining(String adopterName);
}
