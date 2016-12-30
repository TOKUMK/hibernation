package com.hibernation.main;

import com.hibernation.model.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by jonathan on 27/12/16.
 */
public class Earth {

    public static void main(String[] args){

        Animal a = new Animal(1,"lizard", "gekko", "test");

        System.out.println("Noahs ARK" + a.toString());

        Earth earth = new Earth();
        earth.winterIsComing(a);

        HibernateUtil();
    }

    public static void HibernateUtil(){

        // create configuration instance and pass in the
        // hibernate configuration file.
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // version 4.x and up, service registry is being used.
        // The ServiceRegistry scopes the Service.
        // The ServiceRegistry manages the lifecycle of the Service.
        // The ServiceRegistry handles injecting dependencies into the Service
        // (actually both a pull and a push/injection approach are supported).
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        // create a Session factory instance: session factory creates sessions
        // at the request of clients.
        // conceptually, this is a single data store that is thread safe.
        // should be wrapped in a singleton (HibernateUtil being a common convention)
        // the internal state is immutable - once it is created the state is set.
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        // get the current session.
        Session session = factory.getCurrentSession();

        // begin transaction
        session.getTransaction().begin();

        // Print out all required information
        System.out.println("Session Is Opened :: "+ session.isOpen());
        System.out.println("Session Is Connected :: "+ session.isConnected());

        // commit transaction
        session.getTransaction().commit();




    }


    public void winterIsComing(Animal a){

       // Configuration config= Configuration.getConfiguration();

        //Session session = getSessionFactory().getCurrentSession();
        //session.beginTransaction();

        System.out.println("Passed by ref" + a.toString());

       // session.save(a);

        //session.getTransaction().commit();
    }





}
