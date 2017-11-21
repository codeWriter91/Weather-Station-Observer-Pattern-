package com.example.chinmaya.weatherstation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    TextView text1;
    WeatherData weatherData;
    HeatDisplay heatDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        text1 = (TextView) findViewById(R.id.text1);
        weatherData = new WeatherData();
        heatDisplay = new HeatDisplay();
    }

    public void display(float temperature, float humidity, float pressure) {
        text1.setText("Temperature is "+ temperature + ", Humidity is "+ humidity+", Pressure is "+pressure);
    }

    public void setData(View view) {
        try {
            weatherData.setMeasurements(12.5f,89f, 1.05f);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
