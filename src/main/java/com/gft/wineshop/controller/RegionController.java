package com.gft.wineshop.controller;

import com.gft.wineshop.models.Region;
import com.gft.wineshop.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RegionController {

    @Autowired
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
    
}
