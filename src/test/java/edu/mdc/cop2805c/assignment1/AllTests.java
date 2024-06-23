package edu.mdc.cop2805c.assignment1;

import edu.mdc.cop2805c.assignment1.app.VehicleManager;
import edu.mdc.cop2805c.assignment1.base.FossilFuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager;
import edu.mdc.cop2805c.assignment1.inventory.VehicleList;
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author ndelessy
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    private static final int EASY_TEST_POINTS = 2;
    private static final int MEDIUM_TEST_POINTS = 3;
    private static final int HARD_TEST_POINTS = 5;

    private static int score = 0;
    private static int max_score = 0;
    private static final String ROOT_DIR = "./src/test/"; 
    private static final String TEST_FILENAME_1 = ROOT_DIR + "vehicles_1.txt";
    private static final String NEW_TEST_FILENAME = ROOT_DIR + "new_vehicles.txt";
    private static final String GRADE_FILE_NAME = ROOT_DIR + "grade.txt";

    private PrintStream originalOut;
    private ByteArrayOutputStream capturedOutput;
    private InputStream originalIn;


    private static FileWriter gradeFileWriter;
    private static BufferedWriter gradeFileBufferedWriter;


    @Test    
    @Order(1)
    public void fossilFuelVehicleInterfaceExists() throws ClassNotFoundException,
                                                            IOException,
                                                            NoSuchMethodException,
                                                            NoSuchFieldException {
        int possible_points = EASY_TEST_POINTS;
        max_score += possible_points;

        //Class exists?
        String className = "edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle.class; 

        String[] requiredMethodNames = {"estimateFuelEfficiency", "estimateCO2Emissions", "estimateNOxEmissions"};
        Class<?>[][] requiredMethodParameterTypes = {{}, {}, {}};
        String[] requiredFieldNames = {};
        Class<?>[] requiredFieldtypes = {};
        //Test Properties, etc. using reflection
        ClassTester classTester = new ClassTester(
                false, 
                true, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
        );

        score += possible_points;
    }

    @Test
    @Order(2)
    public void electricVehicleInterfaceExists() throws ClassNotFoundException,
                                                        IOException,
                                                        NoSuchMethodException,
                                                        NoSuchFieldException {
        int possible_points = EASY_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.interfaces.ElectricVehicle";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.interfaces.ElectricVehicle.class; 

        String[] requiredMethodNames = {"estimateFuelEfficiencyEquivalent"};
        Class<?>[][] requiredMethodParameterTypes = {{}};
        String[] requiredFieldNames = {};
        Class<?>[] requiredFieldtypes = {};
        ClassTester classTester = new ClassTester(
                false, 
                true, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
        );

        score += possible_points;
    }

    @Test
    @Order(3)
    public void vehicleClassExists() throws ClassNotFoundException,
                                            IOException,
                                            NoSuchFieldException,
                                            NoSuchMethodException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.base.Vehicle";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.base.Vehicle.class;

        String[] requiredMethodNames = {"getVehicleType", "getVehicleSubType", "getDescription"};
        Class<?>[][] requiredMethodParameterTypes = {{}, {}, {}};
        String[] requiredFieldNames = {"VIN", "make", "model", "year"};
        Class<?>[] requiredFieldtypes = {String.class, String.class, String.class, int.class};
        ClassTester classTester = new ClassTester(
                true, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
        );

        score += possible_points;
    }

    @Test
    @Order(4)
    public void fossilFuelCarClassExists() throws ClassNotFoundException,
                                                    IOException,
                                                    NoSuchFieldException,
                                                    NoSuchMethodException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar.class;

        String[] requiredMethodNames = {"getVehicleType", "getVehicleSubType", "getDescription", "estimateFuelEfficiency", "estimateCO2Emissions", "estimateNOxEmissions"};
        Class<?>[][] requiredMethodParameterTypes = {{}, {}, {}, {}, {}, {}};
        String[] requiredFieldNames = {"weightKg", "engineDisplacementL", "transmissionType", "fossilFuelType"};
        Class<?>[] requiredFieldtypes = {int.class, double.class,
            edu.mdc.cop2805c.assignment1.base.TransmissionType.class,
            edu.mdc.cop2805c.assignment1.base.FossilFuelType.class
        };
        ClassTester classTester = new ClassTester(
                false, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
        );

        score += possible_points;
    }

    @Test
    @Order(5)
    public void fossilFuelTruckClassExists() throws ClassNotFoundException,
            IOException,
            NoSuchFieldException,
            NoSuchMethodException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck.class;

        String[] requiredMethodNames = {"getVehicleType", "getVehicleSubType", "getDescription", "estimateFuelEfficiency", "estimateCO2Emissions", "estimateNOxEmissions"};
        Class<?>[][] requiredMethodParameterTypes = {{}, {}, {}, {}, {}, {}};
        String[] requiredFieldNames = {"grossVehicleWeightRatingTon", "engineDisplacementL", "fossilFuelType"};
        Class<?>[] requiredFieldtypes = {int.class, double.class,
            edu.mdc.cop2805c.assignment1.base.FossilFuelType.class
        };
        ClassTester classTester = new ClassTester(
                false, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
        );

        score += possible_points;
    }

    @Test
    @Order(6)
    public void fossilFuelMotorcycleClassExists() throws ClassNotFoundException,
                                                            IOException,
                                                            NoSuchFieldException,
                                                            NoSuchMethodException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle.class;

        String[] requiredMethodNames = {"getVehicleType", "getVehicleSubType", "getDescription", "estimateFuelEfficiency", "estimateCO2Emissions", "estimateNOxEmissions"};
        Class<?>[][] requiredMethodParameterTypes = {{}, {}, {}, {}, {}, {}};
        String[] requiredFieldNames = {"weightKg", "engineDisplacementCC", "frontalAreaSqM"};
        Class<?>[] requiredFieldtypes = {int.class, double.class, double.class};
        ClassTester classTester = new ClassTester(
                false, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
        );

        score += possible_points;
    }

    @Test
    @Order(7)
    public void electricCarClassExists() throws ClassNotFoundException,
                                                IOException,
                                                NoSuchFieldException,
                                                NoSuchMethodException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.vehicles.ElectricCar";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.vehicles.ElectricCar.class;

        String[] requiredMethodNames = {"getVehicleType", "getVehicleSubType", "getDescription", "estimateFuelEfficiencyEquivalent"};
        Class<?>[][] requiredMethodParameterTypes = {{}, {}, {}, {}};
        String[] requiredFieldNames = {"electricityConsumedPerMilekWh"};
        Class<?>[] requiredFieldtypes = {double.class};
        ClassTester classTester = new ClassTester(
                false, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
        );

        score += possible_points;
    }

  
    @Test
    @Order(8)
    public void testEstimateFuelEfficiencyFossilFuelCar() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;
        FossilFuelCar fossilFuelCar = new FossilFuelCar(
                "K1MT9ZBH5L39XE7T", //VIN 
                "Toyota", // make 
                "Corolla LE", // model
                2023, // year
                1288, // weightKg
                1.8, // engineDisplacementL
                TransmissionType.AUTOMATIC, // transmissionType 
                FossilFuelType.GASOLINE // fossilFuelType
        );
        double expResult = 29.6;
        double result = fossilFuelCar.estimateFuelEfficiency();
        assertEquals(
                expResult,
                 result,
                 1,
                 "\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(9)
    public void testEstimateCO2EmissionsFossilFuelCar() throws IOException {

        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;
        FossilFuelCar fossilFuelCar = new FossilFuelCar(
                "K1MT9ZBH5L39XE7T", //VIN 
                "Toyota", // make 
                "Corolla LE", // model
                2023, // year
                1288, // weightKg
                1.8, // engineDisplacementL
                TransmissionType.AUTOMATIC, // transmissionType 
                FossilFuelType.GASOLINE // fossilFuelType
        );
        double expResult = 263000.72;
        double result = fossilFuelCar.estimateCO2Emissions();
        assertEquals(
                expResult,
                 result,
                 1,
                 "\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(10)
    public void testEstimateNOxEmissionsFossilFuelCar() throws IOException {

        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;

        FossilFuelCar fossilFuelCar = new FossilFuelCar(
                "K1MT9ZBH5L39XE7T", //VIN 
                "Toyota", // make 
                "Corolla LE", // model
                2023, // year
                1288, // weightKg
                1.8, // engineDisplacementL
                TransmissionType.AUTOMATIC, // transmissionType 
                FossilFuelType.GASOLINE // fossilFuelType
        );
        double expResult = 20.12;
        double result = fossilFuelCar.estimateNOxEmissions();
        assertEquals(
               expResult
                , result
                , 1
            , "\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(11)
    public void testEstimateFuelEfficiencyFossilFuelTruck() throws IOException {

        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;

        FossilFuelTruck fossilFuelTruck = new FossilFuelTruck(
                "F1IV42N2L6GT8SIP",
                "Volvo",
                "VNL",
                2020,
                33000,
                10.8,
                FossilFuelType.DIESEL
        );
        double expResult = 4.6;
        double result = fossilFuelTruck.estimateFuelEfficiency();
        assertEquals(
                 expResult
                , result
                , 1
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(12)
    public void testEstimateCO2EmissionsFossilFuelTruck() throws IOException {

        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;

        FossilFuelTruck fossilFuelTruck = new FossilFuelTruck(
                "F1IV42N2L6GT8SIP",
                "Volvo",
                "VNL",
                2020,
                33000,
                10.8,
                FossilFuelType.DIESEL
        );
        double expResult = 46963.64;
        double result = fossilFuelTruck.estimateCO2Emissions();
        assertEquals(
                 expResult
                , result
                , 1
                , "\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(13)
    public void testEstimateNOxEmissionsFossilFuelTruck() throws IOException {

        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;

        FossilFuelTruck fossilFuelTruck = new FossilFuelTruck(
                "F1IV42N2L6GT8SIP",
                "Volvo",
                "VNL",
                2020,
                33000,
                10.8,
                FossilFuelType.DIESEL
        );
        double expResult = 21.08;
        double result = fossilFuelTruck.estimateNOxEmissions();
        assertEquals(
                expResult
                , result
                , 1
                , "\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(14)
    public void testEstimateFuelEfficiencyFossilFuelMotorcycle() throws IOException {

        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;

        FossilFuelMotorcycle fossilFuelMotorcycle = new FossilFuelMotorcycle(
                "V1GT6OSK64BVUDIS",
                "Honda",
                "CBR500R",
                2022,
                191,
                471.0,
                0.96
        );
        double expResult = 12.5;
        double result = fossilFuelMotorcycle.estimateFuelEfficiency();
        assertEquals(
                expResult
                , result
                , 1
                , "\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(15)
    public void testEstimateCO2EmissionsFossilFuelMotorcycle() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;

        FossilFuelMotorcycle fossilFuelMotorcycle = new FossilFuelMotorcycle(
                "V1GT6OSK64BVUDIS",
                "Honda",
                "CBR500R",
                2022,
                191,
                471.0,
                0.96
        );

        double expResult = 57674.01;

        double result = fossilFuelMotorcycle.estimateCO2Emissions();
        assertEquals(
                expResult
                , result
                , 1
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(16)
    public void testEstimateNOxEmissionsFossilFuelMotorcycle() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;
        double expResult = 40.12;
        FossilFuelMotorcycle fossilFuelMotorcycle = new FossilFuelMotorcycle(
                "V1GT6OSK64BVUDIS",
                "Honda",
                "CBR500R",
                2022,
                191,
                471.0,
                0.96
        );
        double result = fossilFuelMotorcycle.estimateNOxEmissions();
        assertEquals(
                expResult
                , result
                , 1
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult);
        score += possible_points;
    }

    @Test
    @Order(17)
    public void testEstimateFuelEfficiencyEquivalentElectricCar() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;
        ElectricCar electricCar = new ElectricCar(
                "D1WFPVCXA4EKQSZ1",
                "Tesla",
                "Model S",
                2023,
                0.4
        );
        double expResult = 84.3;
        double result = electricCar.estimateFuelEfficiencyEquivalent();
        assertEquals(
                 expResult
                , result
                , 1
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        score += possible_points;
    }

    @Test
    @Order(18)
    public void testOtherFunctionsElectricCar() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;
        
        String expResult = "Car";
        ElectricCar electricCar = new ElectricCar(
                "D1WFPVCXA4EKQSZ1",
                "Tesla",
                "Model S",
                2023,
                0.4
        );
        String result = electricCar.getVehicleType();
        assertEquals(
                expResult 
                ,result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        expResult = "Electric";
        result = electricCar.getVehicleSubType();
        assertEquals(
                expResult
                , result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        expResult = "Tesla"; 
        result = electricCar.getDescription();
        assertTrue(
                result.toLowerCase().contains(expResult.toLowerCase())
                , "\tYour result: " + result + "\n\tExpected result contains: " + expResult
        );

        score += possible_points;
    }

    @Test
    @Order(19)
    public void testOtherFunctionsFossilFuelCar() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;
        String expResult = "Car";
        FossilFuelCar fossilFuelCar = new FossilFuelCar(
                "K1MT9ZBH5L39XE7T", //VIN 
                "Toyota", // make 
                "Corolla LE", // model
                2023, // year
                1288, // weightKg
                1.8, // engineDisplacementL
                TransmissionType.AUTOMATIC, // transmissionType 
                FossilFuelType.GASOLINE // fossilFuelType
        );
        String result = fossilFuelCar.getVehicleType();
        assertEquals(
                expResult
                , result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
      
        expResult = "Fossil Fuel";
        result = fossilFuelCar.getVehicleSubType();
        assertEquals(
                expResult
                , result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        expResult = "Toyota"; 
        result = fossilFuelCar.getDescription();
        assertTrue(
                result.toLowerCase().contains(expResult.toLowerCase())
                , "\tYour result: " + result + "\n\tExpected result contains: " + expResult
                
        );

        score += possible_points;
    }

    @Test
    @Order(20)
    public void testOtherFunctionsFossilFuelTruck() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;
        FossilFuelTruck fossilFuelTruck = new FossilFuelTruck(
                "F1IV42N2L6GT8SIP",
                "Volvo",
                "VNL",
                2020,
                33000,
                10.8,
                FossilFuelType.DIESEL
        );
        String expResult = "Truck";
        String result = fossilFuelTruck.getVehicleType();
        assertEquals(
                expResult
                , result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        expResult = "Fossil Fuel";
        result = fossilFuelTruck.getVehicleSubType();
        assertEquals(
                expResult
                , result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        expResult = "Volvo"; 
        result = fossilFuelTruck.getDescription();
        assertTrue(
                result.toLowerCase().contains(expResult.toLowerCase())
                , "\tYour result: " + result + "\n\tExpected result contains: " + expResult
        );

        score += possible_points;
    }

    @Test
    @Order(21)
    public void testOtherFunctionsFossilFuelMotorcycle() throws IOException {
        int possible_points = MEDIUM_TEST_POINTS;
        max_score += possible_points;

        FossilFuelMotorcycle fossilFuelMotorcycle = new FossilFuelMotorcycle(
                "V1GT6OSK64BVUDIS",
                "Honda",
                "CBR500R",
                2022,
                191,
                471.0,
                0.96
        );
        String expResult = "Motorcycle";
        String result = fossilFuelMotorcycle.getVehicleType();
        assertEquals(
                expResult
                , result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        expResult = "Fossil Fuel";
        result = fossilFuelMotorcycle.getVehicleSubType();
        assertEquals(
                expResult
                , result
                ,"\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        expResult = "Honda"; //fossilFuelMotorcycle.getMake();
        result = fossilFuelMotorcycle.getDescription();
        assertTrue(
                result.toLowerCase().contains(expResult.toLowerCase())
                , "\tYour result: " + result + "\n\tExpected result contains: " + expResult
        );

        score += possible_points;
    }

    @Test
    @Order(22)
    public void vehicleFileManagerClassExists() throws ClassNotFoundException,
            IOException,
            NoSuchFieldException,
            NoSuchMethodException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager.class;

        String[] requiredMethodNames = {"saveVehiclesToFile", "loadVehiclesFromFile"};
        Class<?>[][] requiredMethodParameterTypes = {{List.class, String.class}, {String.class}};
        String[] requiredFieldNames = {};
        Class<?>[] requiredFieldtypes = {};
        ClassTester classTester = new ClassTester(
                false, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz),
                "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) 
                        + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
                
        );

        score += possible_points;
    }

    @Test
    @Order(23)
    public void testVehicleFileManager() throws IOException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        List<Vehicle> loadedList = VehicleFileManager.loadVehiclesFromFile(TEST_FILENAME_1);
        int expResult = 4;
        int result = loadedList.size();
        assertEquals(
                expResult
                , result
                , "\tNumber of loaded vehicles: " + result + "\n\tExpected number: " + expResult
        );
        String expResults = "K1MT9ZBH5L39XE7T";
        String results = loadedList.get(1).getVIN();
        assertEquals(
                expResult
                , result
                , "\tYour result: " + result + "\n\tExpected result: " + expResult
        );
        FossilFuelCar fossilFuelCar = new FossilFuelCar(
                "K1MT9ZBH5L39XE7T", //VIN 
                "Toyota", // make 
                "Corolla LE", // model
                2023, // year
                1288, // weightKg
                1.8, // engineDisplacementL
                TransmissionType.AUTOMATIC, // transmissionType 
                FossilFuelType.GASOLINE // fossilFuelType
        );
        ElectricCar electricCar = new ElectricCar(
                "D1WFPVCXA4EKQSZ1",
                "Tesla",
                "Model S",
                2023,
                0.4
        );
        FossilFuelTruck fossilFuelTruck = new FossilFuelTruck(
                "F1IV42N2L6GT8SIP",
                "Volvo",
                "VNL",
                2020,
                33000,
                10.8,
                FossilFuelType.DIESEL
        );
        FossilFuelMotorcycle fossilFuelMotorcycle = new FossilFuelMotorcycle(
                "V1GT6OSK64BVUDIS",
                "Honda",
                "CBR500R",
                2022,
                191,
                471.0,
                0.96
        );
        List<Vehicle> l = new ArrayList<>();
        l.add(fossilFuelCar);
        l.add(electricCar);
        l.add(fossilFuelTruck);
        l.add(fossilFuelMotorcycle);
        VehicleFileManager.saveVehiclesToFile(l, NEW_TEST_FILENAME);
        boolean fileCreated = true;
        assertTrue(fileCreated
                , "\tError while saving vehicles to file: "
        );

        score += possible_points;
    }

    @Test
    @Order(24)
    public void vehicleListClassExists() throws ClassNotFoundException,
            IOException,
            NoSuchFieldException,
            NoSuchMethodException {
        int possible_points = EASY_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.inventory.VehicleList";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.inventory.VehicleList.class;

        String[] requiredMethodNames = {"addVehicle", "removeVehicle", "getAllVehicles", "getVehiclesByType", "saveToFile"};
        Class<?>[][] requiredMethodParameterTypes = {
            {edu.mdc.cop2805c.assignment1.base.Vehicle.class},
            {edu.mdc.cop2805c.assignment1.base.Vehicle.class},
            {},
            {String.class},
            {String.class}
        };
        String[] requiredFieldNames = {};
        Class<?>[] requiredFieldtypes = {};
        ClassTester classTester = new ClassTester(
                false, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz)
                , "\tExpected Class: " + className + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames) + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
                
        );

        score += possible_points;
    }

    @Test
    @Order(25)
    public void testVehicleList() throws IOException {
        int possible_points = HARD_TEST_POINTS;
        max_score += possible_points;

        VehicleList list1 = new VehicleList();
        FossilFuelCar fossilFuelCar = new FossilFuelCar(
                "K1MT9ZBH5L39XE7T", //VIN 
                "Toyota", // make 
                "Corolla LE", // model
                2023, // year
                1288, // weightKg
                1.8, // engineDisplacementL
                TransmissionType.AUTOMATIC, // transmissionType 
                FossilFuelType.GASOLINE // fossilFuelType
        );
        ElectricCar electricCar = new ElectricCar(
                "D1WFPVCXA4EKQSZ1",
                "Tesla",
                "Model S",
                2023,
                0.4
        );
        FossilFuelTruck fossilFuelTruck = new FossilFuelTruck(
                "F1IV42N2L6GT8SIP",
                "Volvo",
                "VNL",
                2020,
                33000,
                10.8,
                FossilFuelType.DIESEL
        );
        FossilFuelMotorcycle fossilFuelMotorcycle = new FossilFuelMotorcycle(
                "V1GT6OSK64BVUDIS",
                "Honda",
                "CBR500R",
                2022,
                191,
                471.0,
                0.96
        );
        list1.addVehicle(electricCar);
        list1.addVehicle(fossilFuelCar);
        list1.addVehicle(fossilFuelMotorcycle);
        list1.addVehicle(fossilFuelTruck);
        list1.removeVehicle(fossilFuelTruck);

        int expResult = 3;
        int result = list1.getAllVehicles().size();
        assertEquals(                
                expResult
                , result
                ,"\tNumber of vehicles in list after add/remove: " + result + "\n\tExpected number: " + expResult
        );

        // List<Vehicle> list2 = list1.getVehiclesByType("Car");
        // expResult = 2;
        // result = list2.size();
        // assertEquals("\tNumber of vehicles in list after getVehiclesByType(Car): " + result + "\n\tExpected result: " + expResult,expResult, result);
        //   List<Vehicle> list3 = list1.getVehiclesByType("Truck");
        // expResult = 0;
        //  result = list3.size();
        // assertEquals("\tNumber of vehicles in list after getVehiclesByType(Truck): " + result + "\n\tExpected result: " + expResult,expResult, result);
        //  VehicleList list4 = new VehicleList(TEST_FILENAME);
        //  expResult = 4;
        // result = list4.getAllVehicles().size();
        // assertEquals("\tNumber of loaded vehicles: " + result + "\n\tExpected number: " + expResult,expResult, result);
        score += possible_points;
    }

    @Test
    @Order(26)
    public void vehicleManagerClassExists() throws ClassNotFoundException,
            IOException,
            NoSuchFieldException,
            NoSuchMethodException {
        int possible_points = EASY_TEST_POINTS;
        max_score += possible_points;

        String className = "edu.mdc.cop2805c.assignment1.app.VehicleManager";
        Class.forName(className);
        Class<?> clazz = edu.mdc.cop2805c.assignment1.app.VehicleManager.class;

        String[] requiredMethodNames = {
            "main"
        };
        Class<?>[][] requiredMethodParameterTypes = {
            {String[].class}
        };
        String[] requiredFieldNames = {};
        Class<?>[] requiredFieldtypes = {};
        ClassTester classTester = new ClassTester(
                false, 
                false, 
                requiredMethodNames, 
                requiredMethodParameterTypes,
                requiredFieldNames,  
                requiredFieldtypes 
        );

        assertTrue(
                classTester.testClass(clazz),
                "\tExpected Class: " + className
                + "\n\tExpected methods: " + Arrays.toString(requiredMethodNames)
                + "\n\tExpected field: " + Arrays.toString(requiredFieldNames)
                
        );

        score += possible_points;
    }

    @Test
    @Order(27)
    public void testVehicleManager() throws IOException {
        int possible_points = 2 * HARD_TEST_POINTS;
        max_score += possible_points;

        String testInput = "1\n7\n1\nQ\n";
        byte[] inputBytes = testInput.getBytes();
        InputStream testIn = new ByteArrayInputStream(inputBytes);
        System.setIn(testIn);
        //Starting
        String[] args = {};
        VehicleManager.main(args);

        testInput = "X\nW\nQ\n";
        inputBytes = testInput.getBytes();
        InputStream testIn2 = new ByteArrayInputStream(inputBytes);
        System.setIn(testIn2);
        //Restarting               
        VehicleManager.main(args);

        testInput = "3\nCar\nElectric\nD2WFPVCXA4FKQSZ1\nTesla\nModel S\n2024\n0.4\n1\nQ\n";
        inputBytes = testInput.getBytes();
        InputStream testIn3 = new ByteArrayInputStream(inputBytes);
        System.setIn(testIn3);

        capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));

        //Restarting               
        VehicleManager.main(args);

        String expOutput = "D2WFPVCXA4FKQSZ1";
        String output = capturedOutput.toString();
        assertTrue(
                output.toLowerCase().contains(expOutput.toLowerCase()), 
                "\tYour output: " + output.trim() + "\n\tExpected output contains: " + expOutput
        );

        score += possible_points;
    }

    @BeforeAll
    public static void setUpClass() throws IOException {
        gradeFileWriter = new FileWriter(GRADE_FILE_NAME, false);
        gradeFileBufferedWriter = new BufferedWriter(gradeFileWriter);

    }

    @AfterAll
    public static void tearDownClass() throws IOException {
        appendScoreToGradesFile(Integer.toString(score));
        gradeFileBufferedWriter.close();
        gradeFileWriter.close();
    }

    @BeforeEach
    public void redirectSystemOut() {
        originalOut = System.out;
    }

    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @BeforeEach
    public void redirectSystemIn() {
        originalIn = System.in;
    }

    @AfterEach
    public void restoreSystemIn() {
        System.setIn(originalIn);
    }

    public static void appendScoreToGradesFile(String grade) throws IOException {
        gradeFileBufferedWriter.write(grade + " / " + max_score);
        gradeFileBufferedWriter.newLine();
    }

}
