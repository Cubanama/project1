package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.ElectricVehicle;

public class ElectricCar extends Vehicle implements ElectricVehicle {

 public double electricityConsumedPerMilekWh;   

public ElectricCar(String VIN, String make, String model, int year, double electricityConsumedPerMilekWh) {
this.VIN = VIN;
this.make = make;
this.model = model;
this.year = year;
this.electricityConsumedPerMilekWh = electricityConsumedPerMilekWh;
}

@Override
public String getVehicleType() {
return "Car";
}
@Override
public String getVehicleSubType () {
    return "Electric";
}
@Override
public String getDescription () {
    return "The "+ year + " " + make + " " + model + "powered by electric motors and batteries, offer quiet operation, zero emissions, lower maintenance costs, require access to charging infrastructure.";
}
@Override
      public double estimateFuelEfficiencyEquivalent() {
   double EquivalencyNumber = 33.7;
   return EquivalencyNumber / electricityConsumedPerMilekWh;
}

    @Override
    public String toString() {
        return super.toString() + electricityConsumedPerMilekWh;
    }
      
}