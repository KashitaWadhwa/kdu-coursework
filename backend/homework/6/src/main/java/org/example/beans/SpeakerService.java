package org.example.beans;

import org.example.entity.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeakerService{
    @Bean
    public Speaker generateSpeaker(){
        String brand= (Math.random() < 0.5)? "Sony" : " Bose";
        int price = (brand.equals("Sony")) ? 1000 : 1500;
        return new Speaker(brand,price);
    }
}
