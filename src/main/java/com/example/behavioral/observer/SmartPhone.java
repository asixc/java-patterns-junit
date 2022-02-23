package com.example.behavioral.observer;

public class SmartPhone implements WeatherObserver{
    @Override
    public void update(WeatherType type) {
        System.out.println("Smartphone has been notified of weather change: " + type);
    }
}
