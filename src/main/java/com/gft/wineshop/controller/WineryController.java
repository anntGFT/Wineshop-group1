package com.gft.wineshop.controller;

import com.gft.wineshop.exceptions.WineNotModifiedException;
import com.gft.wineshop.exceptions.WineryForbiddenException;
import com.gft.wineshop.exceptions.WineryNoContentException;
import com.gft.wineshop.exceptions.WineryNotFoundException;
import com.gft.wineshop.models.Winery;
import com.gft.wineshop.services.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class WineryController {
    
    @Autowired
    WineryService service;


    @GetMapping("/api/winery/{id}")
    // Method
    public Optional<Winery> getWinery(@PathVariable(value = "id") int id) throws WineryNotFoundException {

        return Optional.ofNullable(service.findById(id));

    }

    @GetMapping("/api/wineries")
    public List<Winery> getAll() throws WineryNotFoundException {

        return new ArrayList<>(service.findAll());
    }

    @DeleteMapping("/api/winery/delete/{id}")
    public void deleteWinery(@PathVariable(value = "id") int id) throws WineryNotFoundException, WineryForbiddenException {

        service.deleteById(id);

    }

    @PostMapping("/api/winery/create")

    public Winery createWinery(@RequestBody Winery winery) throws WineryForbiddenException, WineryNoContentException {

        return service.save(winery);
    }

    @PutMapping("/api/winery/update/{id}")
    public Winery updateWinery(@PathVariable int id, @RequestBody Winery winery) throws WineryNotFoundException, WineryForbiddenException, WineNotModifiedException {
        return service.update(id, winery);
    }




}
