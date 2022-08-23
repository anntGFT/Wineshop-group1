package com.gft.wineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WineController {
    
    @RequestMapping("/api/wine/{id}")
    @ResponseBody
  
    // Method
    public String getWine(@RequestParam int id)
    {
        return "Tenemos vinico";
    }

}
