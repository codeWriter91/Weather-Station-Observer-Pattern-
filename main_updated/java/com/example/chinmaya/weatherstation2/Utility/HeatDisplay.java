package com.example.chinmaya.weatherstation2.Utility;

import android.util.Log;

import com.example.chinmaya.weatherstation2.MainActivity;
import com.example.chinmaya.weatherstation2.Support.Observer;

public class HeatDisplay implements Observer {


    private String TAG = "ccchhh";
    private WeatherData weatherData;
    private MainActivity mainActivity;
    private float heatIndex;


    public HeatDisplay(WeatherData weatherData) {
        Log.i(TAG, "HeatDisplay: before");
        mainActivity = new MainActivity();
        this.weatherData = weatherData;
        Log.i(TAG, "HeatDisplay: middle");
        this.weatherData.registerObserver(this);
        Log.i(TAG, "HeatDisplay: after");
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        Log.i(TAG, "update: before");
        heatIndex = temp + humidity + pressure;
        Log.i(TAG, "update: middle");
        mainActivity.display(heatIndex);
        Log.i(TAG, "update: after");
    }
}
