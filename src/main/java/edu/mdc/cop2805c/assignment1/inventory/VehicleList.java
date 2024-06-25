package edu.mdc.cop2805c.assignment1.inventory;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class VehicleList {
   public List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleList() {
        this.vehicles = new ArrayList<>();
    }
        public VehicleList(String filename) {
        this.vehicles = VehicleFileManager.loadVehiclesFromFile(filename);
    }
   public void addVehicle(Vehicle vehicle){
       vehicles.add(vehicle);
   }
public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
}
    public List<Vehicle> getAllVehicles() {
       return new ArrayList<>(vehicles);
       }
   
    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {   
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                filteredVehicles.add(vehicle);
            }
        }
return filteredVehicles;
    }
    public void saveToFile(String filename) {
        VehicleFileManager.saveVehiclesToFile(vehicles, filename);
    }
}
    
    
