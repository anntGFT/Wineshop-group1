package com.gft.wineshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gft.wineshop.models.Wine;
import com.gft.wineshop.repositories.WineRepository;

@RestController
public class WineController {

    @Autowired
    WineRepository wineRepository;
    
    @GetMapping("/api/wine/{id}")
     
    // Method
    public Optional<Wine> getWine(@PathVariable(value = "id") int id)
    {
        return wineRepository.findById(id);
    }


    @GetMapping("/api/wines")
    public List<Wine> getAll(){

        return new ArrayList<>(wineRepository.findAll());
    }

}
