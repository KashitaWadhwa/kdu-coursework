package org.example.config;

import org.example.entity.Vehicle;
import org.example.services.factoryspeakerservice.Factory2SpeakerService;
import org.example.services.factorytyreservice.Factory1TyreService;
import org.example.services.factoryspeakerservice.Factory1SpeakerService;
import org.example.services.factorytyreservice.Factory2TyreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"org.example.services", "org.example.inventory", "org.example.functions", "org.example.entity"})
public class AppConfig {

    @Bean
    public List<Vehicle> vehicleList() {
        return new ArrayList<>(); // or initialize with actual data
    }

    @Bean(name="factory1TyreService")
   // @Qualifier("factory1TyreService")
    public Factory1TyreService factory1TyreService() {
        return new Factory1TyreService();
    }

    @Bean(name ="factory1SpeakerService")
    //@Qualifier("factory1SpeakerService")
    public Factory1SpeakerService factory1SpeakerService() {
        return new Factory1SpeakerService();
    }


    @Bean(name = "factory2TyreService")
    //@Qualifier("factory2TyreService")
    public Factory2TyreService factory2TyreService() {
        return new Factory2TyreService();
    }

    @Bean(name ="factory2SpeakerService")
    //@Qualifier("factory2SpeakerService")
    public Factory2SpeakerService factory2SpeakerService() {
        return new Factory2SpeakerService();
    }

}
