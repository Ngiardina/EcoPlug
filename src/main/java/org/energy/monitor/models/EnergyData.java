package org.energy.monitor.models;

public class EnergyData {
     private double voltage;


    private double current;


    public EnergyData(double current, double voltage) {
        this.current = current;
        this.voltage = voltage;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getCurrent(){
        return current;
    }

}