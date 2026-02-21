package org.example;

public class GPU extends Component implements Overclockable{
    private int vramSize;
    private boolean hasRayTracing;
    private int clockSpeed;
    public GPU(String brand, String model, int price, double basePowerConsumption, int vramSize, boolean hasRayTracing, int clockSpeed){
        super(brand, model, price, basePowerConsumption);
        this.vramSize = vramSize;
        this.hasRayTracing = hasRayTracing;
        this.clockSpeed = clockSpeed;
    }
    @Override
    public void boostPerformance(double factor){
        
    }
}
