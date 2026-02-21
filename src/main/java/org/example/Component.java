package org.example;

public abstract class Component {
    private String brand;
    private String model;
    private int price;
    protected double basePowerConsumption;

    public Component(String brand, String model, int price, double basePowerConsumption){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.basePowerConsumption = basePowerConsumption;
    }

    /*GETTERS AND SETTERS*/

    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public int getPrice(){
        return price;
    }
    public double getBasePowerConsumption(){
        return basePowerConsumption;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setBasePowerConsumption(double basePowerConsumption){
        this.basePowerConsumption = basePowerConsumption;
    }




}
