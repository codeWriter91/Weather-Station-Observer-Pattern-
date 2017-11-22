package com.example.chinmaya.weatherstation2.Utility;


import android.util.Log;

import com.example.chinmaya.weatherstation2.Support.Observer;
import com.example.chinmaya.weatherstation2.Support.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject{

    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    private String TAG = "ccchhh";

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        Log.i(TAG, "registerObserver: before "+observers.size() );
        observers.add(o);
        Log.i(TAG, "registerObserver: after "+observers.size());
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        Log.i(TAG, "notifyObservers: before for loop");
        for (int i = 0; i < observers.size(); i++) {
            Log.i(TAG, "notifyObservers: in for loop, before "+observers.size());
            Observer observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
            Log.i(TAG, "notifyObservers: in for loop, after "+observers.size());
        }
    }
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        Log.i(TAG, "setMeasurements: Data = "+temperature+", "+humidity+", "+pressure);
        measurementsChanged();
    }

    private void measurementsChanged() {
        Log.i(TAG, "measurementsChanged: before");
        notifyObservers();
        Log.i(TAG, "measurementsChanged: after");
    }
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
