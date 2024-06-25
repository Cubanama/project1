package edu.mdc.cop2805c.assignment1.base;
        
public abstract class Vehicle
        {
    public String VIN;
    public String make;
    public String model;
    public int year;

    public abstract String getVehicleType();

    public abstract String getVehicleSubType();

    public abstract String getDescription();

    @Override
    public String toString() {
        return getVehicleType() + "," + getVehicleSubType() + "," + VIN + "," + make + "," + model + "," + year + ",";
    }

    public Object getType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMake() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getYear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMiles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
