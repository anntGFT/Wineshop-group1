package com.gft.wineshop.controller;

import com.gft.wineshop.models.Region;
import com.gft.wineshop.repositories.RegionRepository;
import com.gft.wineshop.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegionController {

    @Autowired
    RegionService service;


    @GetMapping("/api/region/{id}")
    // Method
    public Optional<Region> getRegion(@PathVariable(value = "id") int id) {

        return Optional.ofNullable(service.findById(id));

    }

    @GetMapping("/api/regions")
    public List<Region> getAll() {

        return new ArrayList<>(service.findAll());
    }

    @DeleteMapping("/api/region/delete/{id}")
    public void deleteRegion(@PathVariable(value = "id") int id) {

        service.deleteById(id);

    }

    @PostMapping("/api/region/create")
    public Region createRegion(Region region){
        return service.save(region);
    }

    @PutMapping("/api/region/{id}")
    public Region updateRegion(@PathVariable int id, @RequestBody Region region){
        return service.update(id, region);
    }


}
