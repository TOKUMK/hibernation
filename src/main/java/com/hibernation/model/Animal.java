package com.hibernation.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by jonathan on 26/12/16.
 */
@Entity
@DynamicUpdate
@Table(name="animal")
public class Animal implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long     id;
    private String  name;
    private String  type;
    private String  diet;

    public Animal() {
    }

    public Animal(long id, String name, String type, String diet) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.diet = diet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
