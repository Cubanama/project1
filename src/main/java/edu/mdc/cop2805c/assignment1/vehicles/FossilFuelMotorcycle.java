package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

   public class FossilFuelMotorcycle extends Vehicle implements FossilFuelVehicle {
    public int weightKg;
    public double engineDisplacementCC;
    public double frontalAreaSqM;

    public static final double CO2_EMISSION_FACTOR = 4600;
    public static final double NOX_EMISSION_FACTOR = 3.20;
    
    public FossilFuelMotorcycle(String VIN, String make, String model, int year, int weightKg, double engineDisplacementCC, double frontalAreaSqM) {
this.VIN = VIN;
this.make = make;
this.model = model;
this.year = year;
this.weightKg = weightKg;
this.engineDisplacementCC = engineDisplacementCC;
this.frontalAreaSqM = frontalAreaSqM;
    }
   @Override
public String getVehicleType() {
return "Motorcycle";
}
@Override
public String getVehicleSubType () {
    return "Fossil Fuel";
}
@Override
public String getDescription () {
    return "The "+ year + " " + make + " " + model + "powered by internal combustion engines,agile, fuel efficiency, provide limited passenger and cargo space, require regular maintenance.";
}

    @Override
    public double estimateFuelEfficiency() {
        double W = this.weightKg;
        double D = this.engineDisplacementCC;
        double A = this.frontalAreaSqM;
        double cd = 3.5;
        double FE = (46.64 - (0.0039 * W) - (0.008 * D)) / (cd * A);
        return FE;
    }
 @Override
public double estimateCO2Emissions() {
double FuelEfficiency = estimateFuelEfficiency();
    return FuelEfficiency * CO2_EMISSION_FACTOR;
}
@Override 
public double estimateNOxEmissions() {
    double FuelEfficiency = estimateFuelEfficiency();
    return FuelEfficiency * NOX_EMISSION_FACTOR;

}

    @Override
    public String toString() {
        return super.toString() + weightKg + "," + engineDisplacementCC + "," + frontalAreaSqM;
    }

}
  
