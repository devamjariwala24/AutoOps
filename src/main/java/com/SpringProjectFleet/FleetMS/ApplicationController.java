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

    @GetMapping("/hr")
    public String hr(){
        return "/hr/index";
    }

    @GetMapping("/fleet")
    public String fleet(){
        return "/fleet/index";
    }

    @GetMapping("/accounts")
    public String accounts(){
        return "/accounts/index";
    }
    @GetMapping("/helpdesk")
    public String helpdesk(){
        return "/helpdesk/index";
    }

    @GetMapping("/parameters")
    public String parameters(){
        return "/parameters/index";
    }

    @GetMapping("/payroll")
    public String payroll(){
        return "/payroll/index";
    }
}
