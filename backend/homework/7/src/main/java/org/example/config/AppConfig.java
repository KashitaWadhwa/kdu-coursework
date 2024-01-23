package org.example.config;


import org.example.services.SpeakerService;
import org.example.services.TyreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.services","org.example.inventory"})
public class AppConfig {

    @Bean
    public TyreService tyreService(){
        return new TyreService();
    }

    @Bean
    public SpeakerService speakerService(){
        return new SpeakerService();
    }

    @Bean
    @Qualifier("factory1TyreService")
    public TyreService factory1TyreService() {
        return new Factory1TyreService();
    }

    @Bean
    @Qualifier("factory1SpeakerService")
    public SpeakerService factory1SpeakerService() {
        return new Factory1SpeakerService();
    }

}
