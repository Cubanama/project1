package edu.mdc.cop2805c.assignment1.app;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager;
import edu.mdc.cop2805c.assignment1.inventory.VehicleList;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.FossilFuelType; 
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cubaa
 */
public class VehicleManager {
   public static VehicleList vehicleList;
   public static Scanner scanner;
   public static List<Vehicle> vehicles;
   
    public static void main(String[] args) {
         scanner = new Scanner(System.in);
        char userInput;
        
       vehicleList = new VehicleList("vehicles.txt");
        do {
        
            System.out.println("Please enter your choice: \n Press 1 to View all vehicles, \n Press 2 to View vehicles by type, \n Press 3 to Add vehicle, \n Press 4 to Remove an existing vehicle, \n Press 5 to Display fuel efficiency and/or emissions for a vehicle, \n Press 6 to Display fuel efficiency and/or emissions for a vehicle type, \n Press 7 to Display fuel efficiency and/or emissions for all vehicles, \n Press Q to Exit the program");
            
       userInput = scanner.nextLine() .charAt(0);
       switch(userInput) {
           case'1' -> case1();
           case '2' -> case2();
           case '3' -> case3();
           case '4' -> case4();
           case '5' -> case5();
           case '6' -> case6();
           case '7' -> case7();
           case 'Q' -> {
           }
    default -> System.out.println("Not a valid option");    
               }
                }  
       while ( userInput != 'Q');
       VehicleFileManager.saveVehiclesToFile(vehicleList.vehicles, "vehicles.txt");
    }
    public static void case1() {
System.out.println("Below is the list of all vehicles");
        for (Vehicle v: vehicleList.getVehicles()) {
            System.out.println(v);
            
        }
    }
    
    public static void case2() {
        System.out.println("Please enter the type of vehicle you would to see (Truck, car, motorcycle");
        String type = scanner.nextLine();
        
        List<Vehicle> vbt = vehicleList.getVehiclesByType(type);
       
            for (Vehicle bt: vbt) {
                System.out.println(bt);
          
        }
    }
    public static void case3() {
        
        System.out.println("Please enter the type of vehicle (Car, truck, motorcycle");
        String type = scanner.nextLine();

        System.out.println("Please enter Electric or Fossil Fuel?");
         String subtype = scanner.nextLine();
        if (type.equals("Car") && subtype.equals("Fossil Fuel")) {
            
        System.out.println("Please enter VIN");
        String VIN = scanner.nextLine();
        
        System.out.println("Please enter make");
        String make = scanner.nextLine();
        
        System.out.println("Please enter model");
        String model = scanner.nextLine();
        
        System.out.println("Please enter year");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Please enter weightKg");
                int weightKg = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Please enter engineDisplacementL. Please do not enter a letter as your answer.");
                double engineDisplacementL = scanner.nextDouble();
                scanner.nextLine();
                        
        System.out.println("Please enter transmission type. The options are: MANUAL or AUTOMATIC");
        TransmissionType tt = TransmissionType.getTransmissionType (scanner.nextLine());
        
        System.out.println("Please enter fossil fuel Type. The options are: DIESEL or GASOLINE");
        FossilFuelType fft = FossilFuelType.getFossilFuelType (scanner.nextLine());
        
       FossilFuelCar ffc = new FossilFuelCar(VIN, make, model, year, weightKg, engineDisplacementL, tt, fft);
        vehicleList.addVehicle(ffc);
        }
        else if (type.equals("Car") && subtype.equals("Electric")){
            System.out.println("Please enter VIN");
        String VIN = scanner.nextLine();
        
        System.out.println("Please enter make");
        String make = scanner.nextLine();
        
        System.out.println("Please enter model");
        String model = scanner.nextLine();
        
        System.out.println("Please enter year");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Please enter the electricity consumed per Mile.");
                double electricityConsumedPerMilekWh = scanner.nextDouble();
                scanner.nextLine();
                ElectricCar ec = new ElectricCar(VIN, make, model, year, electricityConsumedPerMilekWh);
                vehicleList.addVehicle(ec);
        }
        
         else if (type.equals("Truck")) {
             
                System.out.println("Please enter VIN");
            String VIN = scanner.nextLine();
        
        System.out.println("Please enter make");
        String make = scanner.nextLine();
        
        System.out.println("Please enter model");
        String model = scanner.nextLine();
        
        System.out.println("Please enter year");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Please enter the gross weight.");
        int grossVehicleWeightRatingTon = scanner.nextInt();
                scanner.nextLine();
                
           System.out.println("Please enter engineDisplacementL. Please do not enter a letter as your answer.");
                double engineDisplacementL = scanner.nextDouble();
                scanner.nextLine();    
                
                System.out.println("Please enter fossil fuel Type. The options are DIESEL or GASOLINE):");
        FossilFuelType fft = FossilFuelType.getFossilFuelType(scanner.nextLine());
        
       FossilFuelTruck ft = new FossilFuelTruck(VIN, make, model, year, grossVehicleWeightRatingTon, engineDisplacementL, fft);
        vehicleList.addVehicle(ft);
        
       }
         if (type.equals("Motorcycle")&& subtype.equals("Fossil Fuel")) {
            
        System.out.println("Please enter VIN");
            String VIN = scanner.nextLine();
        
        System.out.println("Please enter make");
        String make = scanner.nextLine();
        
        System.out.println("Please enter model");
        String model = scanner.nextLine();
        
        System.out.println("Please enter year");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Please enter the weight");
                int weightKg = scanner.nextInt();
                scanner.nextLine();
                
        System.out.println("Please enter engineDisplacementCC. Please do not enter a letter as your answer.");
        double engineDisplacementCC = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("Please enter the aerodynamic");
        double frontalAreaSqM = scanner.nextDouble();
        scanner.nextLine();
        
        FossilFuelMotorcycle ffm = new FossilFuelMotorcycle(VIN, make, model, year, weightKg, engineDisplacementCC, frontalAreaSqM);
        vehicleList.addVehicle(ffm);
         }
         }

   

    public static void case4() {
    
    for (int i=0; i < vehicleList.getVehicles().size(); i++){
        char letter=(char)('a'+i);
        System.out.println(letter +":" + vehicleList.getVehicles().get(i));
    }
    System.out.print("Enter vehicle to remove");
String input = scanner.next().toLowerCase(); 
char vehicleToRemove = input.charAt(0); 
scanner.nextLine();
for (int i = 0; i < vehicleList.getVehicles().size(); i++) {
            char letter = (char) ('a' + i);
            if (letter == vehicleToRemove) { 
            
                vehicleList.getVehicles().remove(i);
                System.out.println("Vehicle removed successfully.");
       
            }
                
            }
    }
 private static void case5() {
    
      Scanner scanner = new Scanner(System.in); // Initialize scanner

    for (int i = 0; i < vehicleList.getVehicles().size(); i++) {
        char letter = (char) ('a' + i);
        System.out.println(letter + ": " + vehicleList.getVehicles().get(i));
    }

    System.out.print("Enter the letter of the vehicle you want to see the fuel efficiency and emissions for: ");
    String input = scanner.next().toLowerCase();

    if (!input.isEmpty()) {
        char ef = input.charAt(0);

        if (ef >= 'a' && ef < 'a' + vehicleList.getVehicles().size()) {
            Vehicle est = vehicleList.getVehicles().get(ef - 'a');

            if (est instanceof ElectricCar) {
                ElectricCar car = (ElectricCar) est;
                System.out.println("The equivalent of the electricity consumed by this vehicle is: " + car.estimateFuelEfficiencyEquivalent());
            } else if (est instanceof FossilFuelCar) {
                FossilFuelCar car = (FossilFuelCar) est;
                System.out.println("The fuel efficiency of your car is: " + car.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your car is: " + car.estimateCO2Emissions());
                System.out.println("The NOX emission of your car is: " + car.estimateNOxEmissions());
            } else if (est instanceof FossilFuelTruck) {
                FossilFuelTruck truck = (FossilFuelTruck) est;
                System.out.println("The fuel efficiency of your truck is: " + truck.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your truck is: " + truck.estimateCO2Emissions());
                System.out.println("The NOX emission of your truck is: " + truck.estimateNOxEmissions());
            } else if (est instanceof FossilFuelMotorcycle) {
                FossilFuelMotorcycle motorcycle = (FossilFuelMotorcycle) est;
                System.out.println("The fuel efficiency of your motorcycle is: " + motorcycle.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your motorcycle is: " + motorcycle.estimateCO2Emissions());
                System.out.println("The NOX emission of your motorcycle is: " + motorcycle.estimateNOxEmissions());
            }
        } else {
            System.out.println("Invalid input. Please enter a valid vehicle letter.");
        }
    } else {
        System.out.println("Input is empty. Please enter a valid input.");
    }
}
        

 
private static void case6() {
     System.out.println("Please enter the type of vehicle you would to see (Truck, car, motorcycle");
        String type = scanner.nextLine();
        
        List<Vehicle> vbt = vehicleList.getVehiclesByType(type);
       
            for (Vehicle ag: vbt) {
                System.out.println(ag);
                if (ag instanceof ElectricCar) {
                ElectricCar car = (ElectricCar) ag;
                System.out.println("The equivalent of the electricity consumed by this vehicle is: " + car.estimateFuelEfficiencyEquivalent());
            } else if (ag instanceof FossilFuelCar) {
                FossilFuelCar car = (FossilFuelCar) ag;
                System.out.println("The fuel efficiency of your car is: " + car.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your car is: " + car.estimateCO2Emissions());
                System.out.println("The NOX emission of your car is: " + car.estimateNOxEmissions());
            } else if (ag instanceof FossilFuelTruck) {
                FossilFuelTruck truck = (FossilFuelTruck) ag;
                System.out.println("The fuel efficiency of your truck is: " + truck.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your truck is: " + truck.estimateCO2Emissions());
                System.out.println("The NOX emission of your truck is: " + truck.estimateNOxEmissions());
            } else if (ag instanceof FossilFuelMotorcycle) {
                FossilFuelMotorcycle motorcycle = (FossilFuelMotorcycle) ag;
                System.out.println("The fuel efficiency of your motorcycle is: " + motorcycle.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your motorcycle is: " + motorcycle.estimateCO2Emissions());
                System.out.println("The NOX emission of your motorcycle is: " + motorcycle.estimateNOxEmissions());
            }
}
}
  
 private static void case7() {
   for (Vehicle ah: vehicleList.getVehicles()){ 
       System.out.println("The vehicle type is: " + ah.getClass().getSimpleName());
       System.out.println("The vehicle details are: " + ah);
    if (ah instanceof ElectricCar) {
                ElectricCar car = (ElectricCar) ah;
                System.out.println("The equivalent of the electricity consumed by this vehicle is: " + car.estimateFuelEfficiencyEquivalent());
            } else if (ah instanceof FossilFuelCar) {
                FossilFuelCar car = (FossilFuelCar) ah;
                System.out.println("The fuel efficiency of your car is: " + car.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your car is: " + car.estimateCO2Emissions());
                System.out.println("The NOX emission of your car is: " + car.estimateNOxEmissions());
                System.out.println();
                
            } else if (ah instanceof FossilFuelTruck) {
                FossilFuelTruck truck = (FossilFuelTruck) ah;
                System.out.println("The fuel efficiency of your truck is: " + truck.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your truck is: " + truck.estimateCO2Emissions());
                System.out.println("The NOX emission of your truck is: " + truck.estimateNOxEmissions());
                                System.out.println();

            } else if (ah instanceof FossilFuelMotorcycle) {
                FossilFuelMotorcycle motorcycle = (FossilFuelMotorcycle) ah;
                System.out.println("The fuel efficiency of your motorcycle is: " + motorcycle.estimateFuelEfficiency());
                System.out.println("The CO2 emission of your motorcycle is: " + motorcycle.estimateCO2Emissions());
                System.out.println("The NOX emission of your motorcycle is: " + motorcycle.estimateNOxEmissions()); 
                                System.out.println();

}
}
 }
}
