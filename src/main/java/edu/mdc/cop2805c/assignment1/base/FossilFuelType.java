package edu.mdc.cop2805c.assignment1.base;
        
public enum FossilFuelType {

GASOLINE, DIESEL,;    

    public static FossilFuelType getFossilFuelType(String type) {
        if(type.equals("GASOLINE"))
            return FossilFuelType.GASOLINE;
        else
            return FossilFuelType.DIESEL;
   
}
}