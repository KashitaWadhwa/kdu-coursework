package org.example.services;

import org.example.entity.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface SpeakerService {
    @Bean
    default Speaker generateSpeaker() {
        String brand = (Math.random() < 0.5) ? "Sony" : "Bose";
        int price = (brand.equals("Sony")) ? 1000 : 1500;
        return new Speaker(brand, price);
    }
}
