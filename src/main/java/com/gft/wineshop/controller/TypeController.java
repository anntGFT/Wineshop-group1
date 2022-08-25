package com.gft.wineshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gft.wineshop.exceptions.TypeForbiddenException;
import com.gft.wineshop.exceptions.TypeNoContentException;
import com.gft.wineshop.exceptions.TypeNotFoundException;
import com.gft.wineshop.exceptions.TypeNotModifiedException;
import com.gft.wineshop.models.Region;
import com.gft.wineshop.models.Type;
import com.gft.wineshop.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TypeController {

    @Autowired
    TypeService service;


    @GetMapping("/api/type/{id}")
    // Method
    public Optional<Type> getType(@PathVariable(value = "id") int id) throws TypeNotFoundException {

        return Optional.ofNullable(service.findById(id));

    }

    @GetMapping("/api/types")
    public List<Type> getAll() throws TypeNotFoundException {

        return new ArrayList<>(service.findAll());
    }

    @DeleteMapping("/api/type/delete/{id}")
    public void deleteType(@PathVariable(value = "id") int id) throws TypeNotFoundException, TypeForbiddenException {

        service.deleteById(id);

    }

    @PostMapping("/api/type/create")
    public Type createType(@RequestBody Type type) throws TypeForbiddenException, TypeNoContentException {
        return service.save(type);
    }

    @PutMapping("/api/type/update/{id}")
    public Type updateType(@PathVariable int id, @RequestBody Type type) throws TypeNotFoundException, TypeForbiddenException, TypeNotModifiedException {
        return service.update(id, type);
    }

}
