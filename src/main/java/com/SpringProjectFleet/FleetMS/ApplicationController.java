package com.SpringProjectFleet.FleetMS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/layout")
    public String widget(){
        return "layout";
    }

    @GetMapping("/index2")
    public String Content(){
        return "index2";
    }
}
