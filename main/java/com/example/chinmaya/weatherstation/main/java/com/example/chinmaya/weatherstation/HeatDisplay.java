package com.example.chinmaya.weatherstation;


public class HeatDisplay implements Observer {

    private float temperature;
    private float humidity;
    private float pressure;
    MainActivity mainActivity;
    WeatherData weatherData;

    public HeatDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

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
