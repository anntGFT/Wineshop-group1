package com.gft.wineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TypeController {

    @RequestMapping("/api/type/{id}")
    @ResponseBody
  
    // Method
    public String getType(@RequestParam int id)
    {
        return "Tenemos region";
    }
    
}
