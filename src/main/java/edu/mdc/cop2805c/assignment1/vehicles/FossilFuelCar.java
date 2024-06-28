package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.FossilFuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelCar extends Vehicle implements FossilFuelVehicle {
    public int weightKg;
    public double engineDisplacementL;
    TransmissionType transmissionType;
    FossilFuelType fossilFuelType;


public FossilFuelCar(String VIN, String make, String model, int year, int weightKg, double engineDisplacementL, TransmissionType transmissionType, FossilFuelType fossilFuelType){
this.VIN = VIN;
this.make = make;
this.model = model;
this.year = year;
this.weightKg = weightKg;
this.engineDisplacementL = engineDisplacementL;
this.transmissionType = transmissionType;
this.fossilFuelType = fossilFuelType;
}

    public FossilFuelCar(TransmissionType transmissionType, String VIN, int year) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

@Override
public String getVehicleType() {
return "Car";
}
@Override
public String getVehicleSubType () {
    return "Fossil Fuel";
}
@Override
public String getDescription () {
    return "The "+ year + " " + make + " " + model + "powered by internal combustion engines, offer high performance, produce emissions, require regular maintenance, supported by an extensive fueling infrastructure.";
}
@Override
public double estimateFuelEfficiency() {
double W = this.weightKg; 
double D = this.engineDisplacementL;
final double C = 0.5;
double T;
if (transmissionType == TransmissionType.MANUAL) {
    T = 0.8;
}
else {
    T = 1;
}
double FE_Car = (C * Math.pow(D, 2.5))/(Math.pow(W, 0.6)* T)* 1000;
return FE_Car;
}
@Override
public double estimateCO2Emissions() {
double FuelEfficiency = estimateFuelEfficiency();
if (fossilFuelType == FossilFuelType.GASOLINE){
    double CO2_GASOLINE_CAR_EMISSION_FACTOR = 8887;
    return FuelEfficiency * CO2_GASOLINE_CAR_EMISSION_FACTOR; 
}
else {
    double CO2_DIESEL_CAR_EMISSION_FACTOR = 8260;
    return FuelEfficiency * CO2_DIESEL_CAR_EMISSION_FACTOR;
}
}
@Override 
public double estimateNOxEmissions() {
    double FuelEfficiency = estimateFuelEfficiency();
if (fossilFuelType == FossilFuelType.GASOLINE){
        double NOX_GASOLINE_CAR_EMISSION_FACTOR = 0.68;
    return FuelEfficiency * NOX_GASOLINE_CAR_EMISSION_FACTOR; 
}
else {
        double NOX_DIESEL_CAR_EMISSION_FACTOR = 2.01;
    return FuelEfficiency * NOX_DIESEL_CAR_EMISSION_FACTOR;
}
}

    @Override
    public String toString() {
        return super.toString() + weightKg + "," + engineDisplacementL + "," + transmissionType + "," + fossilFuelType;
    }

}