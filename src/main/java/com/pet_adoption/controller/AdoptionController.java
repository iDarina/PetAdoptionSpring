package com.pet_adoption.controller;

import com.pet_adoption.entitites.Adoption;
import com.pet_adoption.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {

    private final AdoptionService adoptionService;

    @Autowired
    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping
    public ResponseEntity<List<Adoption>> getAllAdoptions() {
        return new ResponseEntity<>(adoptionService.getAllAdoptions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adoption> getAdoptionById(@PathVariable Long id) {
        return new ResponseEntity<>(adoptionService.getAdoptionById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Adoption> createAdoption(@RequestBody Adoption adoption) {
        return new ResponseEntity<>(adoptionService.createAdoption(adoption), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adoption> updateAdoption(@PathVariable Long id, @RequestBody Adoption adoption) {
        adoption.setId(id);
        return new ResponseEntity<>(adoptionService.updateAdoption(adoption), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdoption(@PathVariable Long id) {
        adoptionService.deleteAdoption(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Adoption>> searchAdoptionsByAdopterName(@RequestParam String adopterName) {
        return new ResponseEntity<>(adoptionService.searchAdoptionsByAdopterName(adopterName), HttpStatus.OK);
    }
}
