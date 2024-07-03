    package com.SpringProjectFleet.FleetMS.parameters.controllers;

    import com.SpringProjectFleet.FleetMS.parameters.models.Country;
    import com.SpringProjectFleet.FleetMS.parameters.services.CountryService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.filter.HiddenHttpMethodFilter;


    import java.util.List;

    @Controller
    public class CountryController {

        @Autowired
        private CountryService countryService;

        @GetMapping("/countries")
        public String getAll(Model model){
            List<Country> countries = countryService.getALl();
            model.addAttribute("countries", countries);
           return "parameters/countryList";
        }

        @GetMapping("/countryAdd")
        public String addCountry(){
            return "parameters/countryAdd";
        }

        @GetMapping("/countryEdit{id}")
        public String editCountry(@PathVariable Integer id, Model model){
            Country country = countryService.getById(id);
            model.addAttribute("country", country);
            return "parameters/countryEdit";
        }

        @GetMapping("/countryDetails{id}")
        public String detailsCountry(@PathVariable Integer id, Model model){
            Country country = countryService.getById(id);
            model.addAttribute("country", country);
            return "parameters/countryDetails";
        }

        @PostMapping("/parameters/countryList")
        public String save(Country country){
            countryService.save(country);
            return "redirect:/countries";
        }

        @DeleteMapping("/countries/delete/{id}")
        public String delete(@PathVariable Integer id){
            countryService.delete(id);
            return "redirect:/countries";
        }

        @RequestMapping(value = "/countries/update/{id}", method={RequestMethod.GET, RequestMethod.PUT})
        public String updateCountry(Country country){
            countryService.save(country);
            return "parameters/countryList";
        }

        @Bean
        public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
            return new HiddenHttpMethodFilter();
        }

    }
