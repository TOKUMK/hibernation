package com.hibernation.dao;

import com.hibernation.model.Animal;

import java.util.List;

/**
 * Created by jonathan on 27/12/16.
 */
public interface AnimalDAO {

    public void save(Animal a);

    public List<Animal> listAll();


}
