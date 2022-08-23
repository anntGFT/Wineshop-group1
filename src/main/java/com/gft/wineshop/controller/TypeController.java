package com.gft.wineshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gft.wineshop.models.Type;
import com.gft.wineshop.repositories.TypeRepository;

@RestController
public class TypeController {

    @Autowired
    TypeRepository typeRepository;


    @GetMapping("/api/type/{id}")
     
    // Method
    public Optional<Type> getType(@PathVariable(value = "id") int id)
    {
        return typeRepository.findById(id);
    }


    @GetMapping("/api/types")
    public List<Type> getAll(){

        return new ArrayList<>(typeRepository.findAll());
    }
    
}
