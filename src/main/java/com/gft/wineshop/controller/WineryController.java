package com.gft.wineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WineryController {
    
    @RequestMapping("/api/winery/{id}")
    @ResponseBody
  
    // Method
    public String getWinery(@RequestParam int id)
    {
        return "Tenemos winery amigo";
    }

}
