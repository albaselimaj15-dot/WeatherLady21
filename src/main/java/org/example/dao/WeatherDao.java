package org.example.dao;


//nje klase dao qe ndryshe eshte data access object sherben per te percaktur cfare te dhenash duam te dergojme dhe cfare
//presim ose duam te marrim


import org.example.entity.WeatherData;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    //metode qe merr te dhenat e motit per nje qytet dhe vend

    public List<WeatherData> getWeatherDataByLocation(String city, String country) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //query per te marre te dhenat e motit per qytetin dhe vendin
        // qe kemi vendos.Kjo metode ekzekuton nje HQL(Hibernate Query Language)
        String hql = "FROM WeatherData wd WHERE wd.location.city=:city AND wd.location.country";
        //krijo nje query qe eshte e bazuar ne  hql dhe ekzekuton ne entitetin WeatherData

        Query<WeatherData> query =session.createQuery(hql, WeatherData.class);
        query.setParameter("city",city);
        query.setParameter("country",country);

        List<WeatherData> weatherDataList=query.list(); //kthimi ne liste i te dhenave

        transaction.commit();

        return weatherDataList;
    }
}




