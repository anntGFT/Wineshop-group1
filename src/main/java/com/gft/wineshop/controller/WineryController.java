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

import com.gft.wineshop.models.Winery;
import com.gft.wineshop.repositories.WineryRepository;

@RestController
public class WineryController {
    
    @Autowired
    WineryRepository wineryRepository;

    @GetMapping("/api/winery/{id}")
     
    // Method
    public Optional<Winery> getWinery(@PathVariable(value = "id") int id)
    {
        return wineryRepository.findById(id);
    }


    @GetMapping("/api/wineries")
    public List<Winery> getAll(){

        return new ArrayList<>(wineryRepository.findAll());
    }

}
