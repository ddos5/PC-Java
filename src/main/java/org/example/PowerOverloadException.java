package org.example;

public class PowerOverloadException extends Exception{
    private double requiredPower;
    public PowerOverloadException(String message, double requiredPower){
        super(message);
        this.requiredPower = requiredPower;
    }
    public double getRequiredPower(){
        return requiredPower;
    }
}
