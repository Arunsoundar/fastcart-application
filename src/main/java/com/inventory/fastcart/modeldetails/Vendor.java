package com.inventory.fastcart.modeldetails;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "fastcartvendor")
public class Vendor {

    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
