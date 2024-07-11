package com.SpringProjectFleet.FleetMS;

import com.SpringProjectFleet.FleetMS.parameters.models.Country;
import com.SpringProjectFleet.FleetMS.parameters.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryTest {


    @Autowired
    private CountryRepository countryRepository;


    @Test
    //Find by ID
    public void testFindByID(){
        Country country = countryRepository.findById(3).orElse(null);
        assertNotNull(country);
    }

    //Find By ID Empty

}
