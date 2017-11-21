package com.example.chinmaya.weatherstation;

public interface Observer {
    void update(float temp, float humidity, float pressure);
}
