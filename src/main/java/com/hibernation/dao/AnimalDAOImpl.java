package com.hibernation.dao;

import com.hibernation.model.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by jonathan on 27/12/16.
 */
public class AnimalDAOImpl implements AnimalDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Animal a) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(a);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Animal> listAll() {
        Session session = this.sessionFactory.openSession();
        List<Animal> animalsList = session.createQuery("from Animal").list();
        session.close();
        return animalsList;
    }
}
