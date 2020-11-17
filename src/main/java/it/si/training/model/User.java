package it.si.training.model;

import java.io.Serializable;

/**
 * @author Ulises Sanchez
 * Classe User ben utilizzata come object transfer e rappresentare l'oggetto user
 */
public class User implements Serializable {

    private String name;
    private String username;
    private String address;
    private String phone;

    public User() {
    }

    public User(String name, String username, String address, String phone) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
