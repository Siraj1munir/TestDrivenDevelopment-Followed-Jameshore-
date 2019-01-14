package com.company;

import org.junit.Test;

public class ElectricPowerSwitchTest {

    @Test
    public void testPressBulb() {
        LightBulb light = new LightBulb();
        light.turnOn();
        light.turnOff();
    }

    @Test
    public void testPressFan() {
        Fan fan = new Fan();
        fan.turnOn();
        fan.turnOff();
    }

    @Test
    public void testPressTubeLight(){
        TubeLight tubelight = new TubeLight();
        tubelight.turnOn();
        tubelight.turnOff();
    }

    @Test
    public  void testPressWaterMotor(){
        WaterMotor motor = new WaterMotor();
        motor.turnOn();
        motor.turnOff();
    }
}