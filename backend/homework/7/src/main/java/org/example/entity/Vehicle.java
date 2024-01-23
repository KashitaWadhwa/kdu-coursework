package org.example.entity;

import java.util.Random;

public class Vehicle {

    private final Speaker speaker;

    private final Tyre tyre;

    private final int price;
    public Vehicle(Speaker speaker, Tyre tyre, int price)
    {
        this.speaker=speaker;
        this.tyre=tyre;
        this.price=price;
    }
//    Random random = new Random();
//    int rValue = random.nextInt(10);
//
//    public int calculatePrice(){
//        int generatePrice= (rValue*1000);
//        return (int) (tyre.getPrice() + speaker.getPrice() + generatePrice);
//    }

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
