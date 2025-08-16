package org.example.dao;

import org.example.entity.Location;
import org.example.entity.WeatherData;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LocationDao {

    public void saveLocation(Location location) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(location);
        transaction.commit();

    }
    public Location getLocationByCityAndCountry(String city, String country){
        Session session=HibernateUtil.getSession();
        Transaction transaction= session.beginTransaction();
        String hql="FROM Location WHERE city=:city AND country=:country";

        Query<Location>query=session.createQuery(hql, Location.class);
        query.setParameter("city",city);
        query.setParameter("country",country);

        Location location= query.uniqueResult();
        transaction.commit();

        return location;
    }
}

