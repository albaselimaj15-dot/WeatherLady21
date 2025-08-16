package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity

public class Location {
    @Id
    private UUID id; //UNIVERSAL UNIQEU IDENTIFIER, KA NJE MADHESI PREJ 16 BYTE OSE 128 BIT
    private String city;
    private String region;
    private String country;
    private double latitude;      //KORDINATAT GJEOGRAFIKE
    private double longitude;

    public Location (){

    }
    public Location(UUID id,String city,String region,String country,double latitude,double longitude) {
        this.id = id;
        this.city=city;
        this.country=country;
        this.latitude=latitude;
        this.region=region;
        this.longitude=longitude;
    }

    public String getCity() {
        return city;
    }

    public UUID getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
