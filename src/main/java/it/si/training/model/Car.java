package it.si.training.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID")
    private Long carId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToMany(mappedBy = "cars", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public Car() {
    }

    public Car(Long id, String brand, String model, String category, String description, double price) {
        this.carId = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Car(String brand, String model, String category, String description, double price) {
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }


}
