package com.gft.wineshop.controller;

import com.gft.wineshop.models.Region;
import com.gft.wineshop.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RegionController {

    @Autowired
    RegionRepository repository;
    @RequestMapping("/api/region/{id}")
    @ResponseBody
  
    // Method
    public String getRegion(@RequestParam int id)
    {
        return "Tenemos region";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/regions")
    public List<Region> getAll(){

        return new ArrayList<>(repository.findAll());
}
    
}
