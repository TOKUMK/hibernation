package com.hibernation.main;

import com.hibernation.model.Animal;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
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


       // ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        // create a Session factory instance: session factory creates sessions
        // at the request of clients.
        // conceptually, this is a single data store that is thread safe.
        // should be wrapped in a singleton (HibernateUtil being a common convention)
        // the internal state is immutable - once it is created the state is set.


        //SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);


        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();






        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "hibernate.cfg.xml" )
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();




//        sessionFactory.setPackagesToScan(
//                new String[] { "org.baeldung.ex.mappingexception.persistence.model" });
//        sessionFactory.

        // get the current session.
        Session session = sessionFactory.getCurrentSession();

        // begin transaction
        session.getTransaction().begin();

        // Print out all required information
        System.out.println("Session Is Opened :: "+ session.isOpen());
        System.out.println("Session Is Connected :: "+ session.isConnected());
        System.out.println("Creating object");
        Animal a = new Animal(1,"monkey", "island", "test2");
        System.out.println("Persisting");

        session.save(a);
        System.out.println("Persisted");

        // commit transaction
        session.getTransaction().commit();

        System.out.println("closed");


//        //session.save(a);
//
//        Transaction tx = null;
//        Integer animalID = null;
//        try{
//            tx = session.beginTransaction();
//            animalID = (Integer) session.save(a);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        //return animalID;

    }


//    public void winterIsComing(Animal a){
//
//       // Configuration config= Configuration.getConfiguration();
//
//        //Session session = getSessionFactory().getCurrentSession();
//        //session.beginTransaction();
//
//        System.out.println("Passed by ref" + a.toString());
//
//       // session.save(a);
//
//        //session.getTransaction().commit();
//    }





}
