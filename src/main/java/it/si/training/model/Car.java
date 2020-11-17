package it.si.training.model;

import java.io.Serializable;

public class Car implements Serializable {

    private String model;
    private String brand;
    private double price;
    private String color;
    private String category;

    public Car() {
    }

    public Car(String model, String brand, double price, String color, String category) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
