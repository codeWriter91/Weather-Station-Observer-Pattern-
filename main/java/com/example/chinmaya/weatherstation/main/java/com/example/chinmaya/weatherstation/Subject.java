package com.example.chinmaya.weatherstation;


public interface Subject {
    public void notifyObservers();
    public void  registerObserver(Observer observer);
}
