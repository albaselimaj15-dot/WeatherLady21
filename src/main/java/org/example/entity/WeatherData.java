package org.example.entity;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

@Entity
public class WeatherData {
    private static final Logger log = LoggerFactory.getLogger(WeatherData.class);
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Id gjenerohet automatikisht
    private Long id; //primary key

    private LocalDate date; //data kur jane marre te dhenat .. klase e gatshme kjo

    private double temperature;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDirection;


    @ManyToOne
    @JoinColumn(name="location_id") //kolona qe lidhet me location
    private Location location; //lidhja me klasen location

    public WeatherData(){

    }
   public WeatherData(double temperature,double pressure,double humidity,double windSpeeddouble, double windDirection){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        this.windSpeed=windSpeeddouble;
        this.windDirection=windDirection;
   }

    public Long getId() {
        return id;
    }

    public double getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", date=" + date +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", location=" + location +
                '}';
    }

    //krijo konstruktoret dhe getter settter
}
