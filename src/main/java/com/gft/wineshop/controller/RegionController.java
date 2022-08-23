package com.gft.wineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegionController {

    @RequestMapping("/api/region/{id}")
    @ResponseBody
  
    // Method
    public String getRegion(@RequestParam int id)
    {
        return "Tenemos region";
    }
    
}
