package com.example.chinmaya.weatherstation;

import java.util.ArrayList;


public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    Observer observer;

    public WeatherData() {
        observers = new ArrayList<Observer>();
        observers.add(observer);
    }


    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();
    }
}
