package it.si.training.model;

import java.io.Serializable;

public class Car implements Serializable {

    private Long carId;
    private String brand;
    private String model;
    private String category;
    private double price;

    public Car() {
    }

    public Car( Long carId, String brand, String model, String category, double price) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.price = price;

    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
