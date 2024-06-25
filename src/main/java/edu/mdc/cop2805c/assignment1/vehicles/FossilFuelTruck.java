package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.FossilFuelType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelTruck extends Vehicle implements FossilFuelVehicle {
    public int grossVehicleWeightRatingTon;
    public double engineDisplacementL;
    FossilFuelType fossilFuelType;

final int CO2_GASOLINE_TRUCK_EMISSION_FACTOR = 11100;
final int CO2_DIESEL_TRUCK_EMISSION_FACTOR = 10250;
final double NOX_GASOLINE_TRUCK_EMISSION_FACTOR = 2.10;
final double NOX_DIESEL_TRUCK_EMISSION_FACTOR = 4.60;

public FossilFuelTruck(String VIN, String make, String model, int year, int grossVehicleWeightRatingTon, double engineDisplacementL, FossilFuelType fossilFuelType){
this.VIN = VIN;
this.make = make;
this.model = model;
this.year = year;
this.grossVehicleWeightRatingTon = grossVehicleWeightRatingTon;
this.engineDisplacementL = engineDisplacementL;
this.fossilFuelType = fossilFuelType;
}
   @Override
public String getVehicleType() {
return "Truck";
}
@Override
public String getVehicleSubType () {
    return "Fossil Fuel";
}
@Override
public String getDescription () {
    return "The "+ year + " " + make + " " + model + "powered by internal combustion engines, torque to transport heavy loads, offer significant cargo capacity, require regular maintenance.";
}
@Override 
public double estimateFuelEfficiency() {
    double constant;
    if (fossilFuelType == FossilFuelType.DIESEL) {
        constant = 14;
        }
    else {
        constant = 10;
    }
return 1000 * (engineDisplacementL * constant) / grossVehicleWeightRatingTon;
}
@Override
public double estimateCO2Emissions() {
double FuelEfficiency = estimateFuelEfficiency();
if (fossilFuelType == FossilFuelType.GASOLINE){
    return FuelEfficiency * CO2_GASOLINE_TRUCK_EMISSION_FACTOR; 
}
else {
    return FuelEfficiency * CO2_DIESEL_TRUCK_EMISSION_FACTOR;
}
}
@Override 
public double estimateNOxEmissions() {
    double FuelEfficiency = estimateFuelEfficiency();
if (fossilFuelType == FossilFuelType.GASOLINE){
    return FuelEfficiency * NOX_GASOLINE_TRUCK_EMISSION_FACTOR; 
}
else {
    return FuelEfficiency * NOX_DIESEL_TRUCK_EMISSION_FACTOR;

}
}

    @Override
    public String toString() {
        return super.toString() + grossVehicleWeightRatingTon + "," + engineDisplacementL + "," + fossilFuelType;
    }

}