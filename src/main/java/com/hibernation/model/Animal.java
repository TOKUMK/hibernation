package com.hibernation.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jonathan on 26/12/16.
 */
@Entity
@Table(name="Animal")
public class Animal implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int     id;
    private String  name;
    private String  type;
    private String  diet;

    public Animal() {
    }

    public Animal(int id, String name, String type, String diet) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.diet = diet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", diet='" + diet + '\'' +
                '}';
    }
}
