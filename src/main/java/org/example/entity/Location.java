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
    private double latitude;
    private double longitude;

    public Location (){

    }
    public Location(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setId(UUID id) {
        this.id = id;
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
