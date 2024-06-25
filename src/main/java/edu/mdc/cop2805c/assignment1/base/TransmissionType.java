package edu.mdc.cop2805c.assignment1.base;

public enum TransmissionType {
 
    AUTOMATIC, MANUAL,;
  
    public static TransmissionType getTransmissionType(String Type){
        Object type = null;
        if("AUTOMATIC".equals(type)) {
            return TransmissionType.AUTOMATIC;
        } else {
            return TransmissionType.MANUAL;
        }
}
}