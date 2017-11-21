package com.example.chinmaya.weatherstation;


public class HeatDisplay implements Observer {

    private float temperature;
    private float humidity;
    private float pressure;
    MainActivity mainActivity;
    @Override
    public void update(float temp, float humidity, float pressure) {

        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        displayHeat();
    }

    private void displayHeat() {
        mainActivity.display(temperature,humidity,pressure);
    }

}
