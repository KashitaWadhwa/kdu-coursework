package org.example.beans;

import org.example.entity.Speaker;
import org.example.entity.Tyre;
import org.springframework.stereotype.Service;

@Service
public class SpeakerService{
    public Speaker generateSpeaker(){
        String brand= (Math.random() < 0.5)? "Sony" : " Bose";
        int price = (brand.equals("Sony")) ? 1000 : 1500;
        return new Speaker(brand,price);
    }
}
