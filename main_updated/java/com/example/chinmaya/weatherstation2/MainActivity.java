package com.example.chinmaya.weatherstation2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chinmaya.weatherstation2.Utility.HeatDisplay;
import com.example.chinmaya.weatherstation2.Utility.WeatherData;

public class MainActivity extends AppCompatActivity {
    public TextView text1;
    public WeatherData weatherData;
    public HeatDisplay heatDisplay;
    private String TAG = "ccchhh";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);
        weatherData = new WeatherData();
        heatDisplay = new HeatDisplay(weatherData);
        try {
            setData();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "onCreate: exception "+e.getMessage());
            Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        weatherData.setMeasurements(82, 70, 29.2f);
    }

    public void display(float heatIndex) {
//        text1.setText("Heat index is "+heatIndex);
        Toast.makeText(this, "HI is " + heatIndex, Toast.LENGTH_SHORT).show();
    }

}
