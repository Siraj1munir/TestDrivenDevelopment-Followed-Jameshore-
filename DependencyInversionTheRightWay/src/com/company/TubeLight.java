package com.company;

public class TubeLight implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("TubeLight: Tube Light turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("TubeLight: Tube Light turned off...");
    }
}