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
    @GetMapping("/parameters/layout")
    public String widget1(){
        return "layout";
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

    @GetMapping("/reports")
    public String reports(){
        return "/reports/index";
    }

    @GetMapping("/security")
    public String security(){
        return "/security/index";
    }


}


