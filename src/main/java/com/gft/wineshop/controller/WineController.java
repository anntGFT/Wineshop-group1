package com.gft.wineshop.controller;

import com.gft.wineshop.models.Wine;
import com.gft.wineshop.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class WineController {

    @Autowired
    WineService service;

    @GetMapping("/api/wine/{id}")
    // Method
    public Optional<Wine> getWine(@PathVariable(value = "id") int id) {

        return Optional.ofNullable(service.findById(id));

    }

    @GetMapping("/api/wines")
    public List<Wine> getAll() {

        return new ArrayList<>(service.findAll());
    }

    @GetMapping("/api/recommend/best/{id}")
    // Method
    public List<Wine> getBest(@PathVariable(value = "limit") int limit) {

        List<Wine> bestTen = service.findAll().parallelStream()
            
        .sorted(Comparator.comparingDouble(Wine::getRating).thenComparingInt(Wine::getNumReviews).reversed())

        .limit(limit)

        .collect(Collectors.toList());

        return bestTen;

    }

    @GetMapping("/api/recommend/expensive/{id}")
    // Method
    public List<Wine> getMostExpensive(@PathVariable(value = "id") int id) {

        List<Wine> mostExpensive = service.findAll().parallelStream()
            
        .sorted(Comparator.comparingDouble(Wine::getPrice).reversed())

        .limit(id)

        .collect(Collectors.toList());

        return mostExpensive;

    }

    @GetMapping("/api/recommend/bang/{id}")
    // Method
    public List<Wine> getBestBang(@PathVariable(value = "id") int id) {

        List<Wine> bestBang = service.findAll().parallelStream()
            
            .sorted(Comparator.comparingDouble(Wine::getPrice).reversed())

            .limit(id)

            .collect(Collectors.toList());

        return bestBang;

    }

    @GetMapping("/api/recommend/vintage/{limit}")
    // Method
    public Map<String,List<Wine>> getVintage(@PathVariable(value = "limit") int limit) {

        return service.findAll().parallelStream()

            .sorted(Comparator.comparing(Wine::getRating).thenComparingInt(Wine::getNumReviews).reversed())

            .limit(limit)

            .collect(Collectors.groupingBy(Wine::getYear));

    }





    @DeleteMapping("/api/wine/delete/{id}")
    public void deleteRegion(@PathVariable(value = "id") int id) {

        service.deleteById(id);

    }

    @PostMapping("/api/wine/create")
    public Wine createWine(@RequestBody Wine wine){
        return service.save(wine);
    }

    @PutMapping("/api/wine/update/{id}")
    public Wine updateRegion(@PathVariable int id, @RequestBody Wine wine){
        return service.update(id, wine);
    }



}
