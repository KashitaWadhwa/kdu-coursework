package org.example.entity;

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
