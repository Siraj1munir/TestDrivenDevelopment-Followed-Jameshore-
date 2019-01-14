package com.company;

import org.junit.Test;

public class ElectricPowerSwitchTest {

    @Test
    public void testPressBulb() {
        Switchable switchableBulb = new LightBulb();
        Switch bulbPowerSwitch = new ElectricPowerSwitch(switchableBulb);
        bulbPowerSwitch.press();
        bulbPowerSwitch.press();
    }

    @Test
    public void testPressFan() {
        Switchable switchableFan = new Fan();
        Switch fanPowerSwitch = new ElectricPowerSwitch(switchableFan);
        fanPowerSwitch.press();
        fanPowerSwitch.press();
    }

    @Test
    public void testPressTubeLight(){
        Switchable switchableTubeLight= new TubeLight();
        Switch TubeLightPowerSwitch= new ElectricPowerSwitch(switchableTubeLight);
        TubeLightPowerSwitch.press();
        TubeLightPowerSwitch.press();
    }

    @Test
    public  void testPressWaterMotor(){
        Switchable switchableWaterMotor= new WaterMotor();
        Switch WaterMotorPowerSwitch= new ElectricPowerSwitch(switchableWaterMotor);
        WaterMotorPowerSwitch.press();
        WaterMotorPowerSwitch.press();
    }
}