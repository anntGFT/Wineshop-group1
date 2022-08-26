package com.gft.wineshop.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gft.wineshop.exceptions.WineForbiddenException;
import com.gft.wineshop.exceptions.WineNoContentException;
import com.gft.wineshop.exceptions.WineNotFoundException;
import com.gft.wineshop.exceptions.WineNotModifiedException;
import com.gft.wineshop.models.Region;

import com.gft.wineshop.models.Wine;
import com.gft.wineshop.repositories.WineRepository;

import com.gft.wineshop.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class WineController {

    @Autowired
    WineService service;
    @Autowired
    WineRepository repository;

    @GetMapping("/api/wine/{id}")
    // Method
    public Optional<Wine> getWine(@PathVariable(value = "id") int id) throws WineNotFoundException {

        return Optional.ofNullable(service.findById(id));

    }

    @GetMapping("/api/wines")
    public List<Wine> getAll() throws WineNotFoundException {

        return new ArrayList<>(service.findAll());
    }

    @GetMapping("/api/recommend/best/{limit}")
    // Method
    public List<Wine> getBest(@PathVariable(value = "limit") int limit) {

        List<Wine> bestTen = service.findAll().parallelStream()
            
        .sorted(Comparator.comparingDouble(Wine::getRating).thenComparingInt(Wine::getNumReviews).reversed())

        .limit(limit)

        .collect(Collectors.toList());

        return bestTen;

    }

    @GetMapping("/api/recommend/expensive/{limit}")
    // Method
    public List<Wine> getMostExpensive(@PathVariable(value = "limit") int limit) {

        List<Wine> mostExpensive = service.findAll().parallelStream()
            
        .sorted(Comparator.comparingDouble(Wine::getPrice).reversed())

        .limit(limit)

        .collect(Collectors.toList());

        return mostExpensive;

    }

    @GetMapping("/api/recommend/bang/{id}")
    // Method
    public List<Wine> getBang(@RequestParam(required = false, defaultValue = "10") Integer top) {

        return service.findByBang(10);

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
    public void deleteRegion(@PathVariable(value = "id") int id) throws WineNotFoundException, WineForbiddenException {

        service.deleteById(id);

    }

    @PostMapping("/api/wine/create")

    public Wine createWine(@RequestBody Wine wine) throws WineForbiddenException, WineNoContentException {

        return service.save(wine);
    }

    @PutMapping("/api/wine/update/{id}")
    public Wine updateRegion(@PathVariable int id, @RequestBody Wine wine) throws WineNotFoundException, WineForbiddenException, WineNotModifiedException {
        return service.update(id, wine);
    }



}
