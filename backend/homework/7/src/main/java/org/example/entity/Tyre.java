package org.example.entity;

public class Tyre {

    private final String brand;
    private final int price;

    public Tyre(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }


}
