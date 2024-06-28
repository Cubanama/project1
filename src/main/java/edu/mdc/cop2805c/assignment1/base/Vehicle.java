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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVIN() {
        return VIN;
    }
}
