package org.example.entity;

public class Tyre {

    private String brand;
    private int price;

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
