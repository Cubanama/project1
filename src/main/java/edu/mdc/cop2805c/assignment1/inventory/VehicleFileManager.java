package edu.mdc.cop2805c.assignment1.inventory;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;
import edu.mdc.cop2805c.assignment1.base.FossilFuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class VehicleFileManager {
    
public static void saveVehiclesToFile(List<Vehicle> vehicles, String filename){
    FileWriter fileWriter = null;
    try {
        fileWriter = new FileWriter(filename);
       
        
        for( Vehicle vehicle: vehicles){
            System.out.println(vehicle.toString());
            fileWriter.write( vehicle.toString() + "\n" );
        }
        
        } catch (IOException ex) {
        Logger.getLogger("ERROR writing to file");
    } finally {
        try {
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger("ERROR writing to file");
        }
    }
}
public static List<Vehicle> loadVehiclesFromFile(String filename){
    List<Vehicle> list = new ArrayList<>();
    try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                Vehicle vehicles = null;
                String[] tokens = line.split(",");
                
                String vehicleType = tokens[0];
                String vehicleSubType = tokens [1];
                String VIN = tokens[2];
                String Make = tokens[3];
                String Model = tokens[4];
                int Year = Integer.parseInt(tokens[5]);

if (vehicleType.equals("Car") && vehicleSubType.equals("Fossil Fuel")){
    int weightKg = Integer.parseInt(tokens[6]);
    double engineDisplacementL = Double.parseDouble(tokens[7]);
    TransmissionType transmissionType = TransmissionType.getTransmissionType(tokens[8]);
    FossilFuelType fossilFuelType = FossilFuelType.getFossilFuelType(tokens[9]);
    
    vehicles = new FossilFuelCar(VIN, Make, Model, Year, weightKg, engineDisplacementL, transmissionType, fossilFuelType);
                        
                   
                        }
else if (vehicleType.equals("Car") && vehicleSubType.equals("Electric")){
    double electricityConsumedPerMilekWh = Double.parseDouble(tokens[6]);
    vehicles = new ElectricCar(VIN, Make, Model, Year, electricityConsumedPerMilekWh );
}
else if (vehicleType.equals("Truck") && vehicleSubType.equals("Fossil Fuel")){
    int grossVehicleWeightRatingTon = Integer.parseInt(tokens[6]);
    double engineDisplacementL = Double.parseDouble(tokens[7]);
    FossilFuelType fossilFuelType = FossilFuelType.getFossilFuelType(tokens[8]);
vehicles = new FossilFuelTruck(VIN, Make, Model, Year, grossVehicleWeightRatingTon, engineDisplacementL, fossilFuelType);
}
else if (vehicleType.equals("Motorcycle") && vehicleSubType.equals("Fossil Fuel")){
    int weightKg = Integer.parseInt(tokens[6]);
    double engineDisplacementCC = Double.parseDouble(tokens[7]);
    double frontalAreaSqM = Double.parseDouble(tokens[8]);
 vehicles = new FossilFuelMotorcycle(VIN, Make, Model, Year, weightKg, engineDisplacementCC, frontalAreaSqM);
}
    if (vehicles != null) {
        list.add(vehicles);
    }
}
reader.close();
} catch (IOException e) {
            System.out.println("Error while reading the file");
        }
    return list;
}
public static void main(String[] args) {
List<Vehicle> vehicleList = VehicleFileManager.loadVehiclesFromFile("vehicles.txt");
    for(Vehicle v : vehicleList){
        System.out.println(v);
    }
    
    }
}



