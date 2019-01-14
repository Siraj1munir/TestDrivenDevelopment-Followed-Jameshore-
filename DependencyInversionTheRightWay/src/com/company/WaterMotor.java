package com.company;

public class WaterMotor implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("WaterMotor: Water Motor turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Water Motor: Water Motor turned off...");
    }
}