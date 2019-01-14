package com.company;

public class ElectricPowerSwitch {
    public LightBulb lightBulb;
    public Fan fan;
    public TubeLight tubeLight;
    public WaterMotor waterMotor;
    public boolean on;
    public ElectricPowerSwitch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
        this.on = false;
    }
    public ElectricPowerSwitch(Fan fan) {
        this.fan = fan;
        this.on = false;
    }
    public ElectricPowerSwitch(TubeLight tubeLight) {
        this.tubeLight = tubeLight;
        this.on = false;
    }
    public ElectricPowerSwitch(WaterMotor waterMotor) {
        this.waterMotor = waterMotor;
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }
    public void press(){
        boolean checkOn = isOn();
        if (checkOn) {
            lightBulb.turnOff();
            this.on = false;
        } else {
            lightBulb.turnOn();
            this.on = true;
        }

    }
}