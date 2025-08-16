package org.example.dao;


//nje klase dao qe ndryshe eshte data access object sherben per te percaktur cfare te dhenash duam te dergojme dhe cfare
//presim ose duam te marrim


import org.example.entity.WeatherData;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WeatherDao {

    //metoda oer te ruajtur nje objekt te tipit weatherdata ne databaze

    public void saveWeatherData(WeatherData weatherData){
        Session session= HibernateUtil.getSession();

        //nje transaksion eshte nje grup operacionesh qe duhet te perfundojne te gjitha me sukses
        //ose te mos behen fare. Nese ndodh nje problem gjate transaksionit atehere duhet te anullohet. Sigurojne siguri
        Transaction transaction= session.beginTransaction();
        session.persist(weatherData);  //ruan objektin weatherdata ne databaze
                                       //krijon nje rrjesht te ri ne tabele
        transaction.commit(); //siguron qe ndryshimet e bera jane ruajtur ne databaze
    }
}
