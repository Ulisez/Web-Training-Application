package it.si.training.model;

import java.io.Serializable;

/**
 * @author Ulises Sanchez
 * Classe User ben utilizzata come object transfer e rappresentare l'oggetto user
 */
public class User implements Serializable {

    private String name;
    private String lastname;
    private String address;
    private String phone;

    public User() {
    }

    public User(String name, String lastname, String address, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
