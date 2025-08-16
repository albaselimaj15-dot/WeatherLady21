package org.example.util;

import org.example.entity.Location;
import org.example.entity.WeatherData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {


    //eshte nje objekt qe krijon dhe menaxhon sessionet ne Hibernate
    //Session eshte lidhje me bazen e te dhenave dhe perdoret per te realizuar operacione si save , update ose search


    //KY blloku statik ekzekutohet vetem nje here kur inicializohet Hibernate

    private static SessionFactory sessionFactory;

    static{

        try{
            //Thirrjen e medoted configure() per te lexuar filen hibernate.cfg.xml i cili permban te gjitha
            //konfigurimet e hibernate

            sessionFactory=new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(WeatherData.class)
                    //kto dy rrjeshta shtojne klasat qe kane anotation @Entity, @Table

                    .buildSessionFactory();
        } catch(Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }


    //hapja e nje sessioni te ri

    public static Session getSession(){
        return sessionFactory.openSession();
    }


    //mbyllja
    public static void shutdown(){
        sessionFactory.close();
    }
}
