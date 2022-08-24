package com.gft.wineshop.controller;

import com.gft.wineshop.models.Region;
import com.gft.wineshop.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class RegionController {

    @Autowired(required = false)
    RegionRepository regionRepository;



    @GetMapping("/api/region/{id}")
    // Method
    public Optional<Region> getRegion(@PathVariable(value = "id") int id){

        return regionRepository.findById(id);

    }

    @GetMapping("/api/regions")
    public List<Region> getAll(){


        return new ArrayList<>(regionRepository.findAll());
    }   

    @DeleteMapping("/api/region/delete/{id}")
    public void deleteRegion(@PathVariable(value = "id") int id) {

        regionRepository.deleteById(id);

    }

    
}
