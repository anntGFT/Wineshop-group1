package com.gft.wineshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gft.wineshop.exceptions.WineForbiddenException;
import com.gft.wineshop.exceptions.WineNoContentException;
import com.gft.wineshop.exceptions.WineNotFoundException;
import com.gft.wineshop.exceptions.WineNotModifiedException;
import com.gft.wineshop.models.Region;
import com.gft.wineshop.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.gft.wineshop.models.Wine;
import com.gft.wineshop.repositories.WineRepository;

@RestController
public class WineController {

    @Autowired
    WineService service;

    @GetMapping("/api/wine/{id}")
    // Method
    public Optional<Wine> getWine(@PathVariable(value = "id") int id) throws WineNotFoundException {

        return Optional.ofNullable(service.findById(id));

    }

    @GetMapping("/api/wines")
    public List<Wine> getAll() throws WineNotFoundException {

        return new ArrayList<>(service.findAll());
    }

    @DeleteMapping("/api/wine/delete/{id}")
    public void deleteRegion(@PathVariable(value = "id") int id) throws WineNotFoundException, WineForbiddenException {

        service.deleteById(id);

    }

    @PostMapping("/api/wine/create")
    public Wine createWine(Wine wine) throws WineForbiddenException, WineNoContentException {
        return service.save(wine);
    }

    @PutMapping("/api/wine/update/{id}")
    public Wine updateRegion(@PathVariable int id, @RequestBody Wine wine) throws WineNotFoundException, WineForbiddenException, WineNotModifiedException {
        return service.update(id, wine);
    }



}
