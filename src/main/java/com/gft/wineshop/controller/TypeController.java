package com.gft.wineshop.controller;

import com.gft.wineshop.models.Type;
import com.gft.wineshop.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TypeController {

    @Autowired
    TypeService service;


    @GetMapping("/api/type/{id}")
    // Method
    public Optional<Type> getType(@PathVariable(value = "id") int id) throws Exception{

        return Optional.ofNullable(service.findById(id));

    }

    @GetMapping("/api/types")
    public List<Type> getAll() {

        return new ArrayList<>(service.findAll());
    }

    @DeleteMapping("/api/type/delete/{id}")
    public void deleteType(@PathVariable(value = "id") int id) {

        service.deleteById(id);

    }

    @PostMapping("/api/type/create")
    public Type createType(@RequestBody Type type){
        return service.save(type);
    }

    @PutMapping("/api/type/update/{id}")
    public Type updateType(@PathVariable int id, @RequestBody Type type) throws Exception{
        return service.update(id, type);
    }

}
