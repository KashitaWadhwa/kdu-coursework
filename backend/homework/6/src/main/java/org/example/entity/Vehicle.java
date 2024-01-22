package org.example.entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Vehicle {


    private int price;
    public Vehicle(Speaker speaker, Tyre tyre)
    {
        this.speaker=speaker;
        this.tyre=tyre;
        this.price=calculatePrice();
    }
    Random random = new Random();
    int rValue = random.nextInt(10);

    public int calculatePrice(){
        int generatePrice= (rValue*1000);
        return (int) (tyre.getPrice() + speaker.getPrice() + generatePrice);
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public int getPrice() {
        return price;
    }
}
