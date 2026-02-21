package org.example;

public class GPU extends Component implements Overclockable{
    private int vramSize;
    private boolean hasRayTracing;
    private double clockSpeed;
    public GPU(String brand, String model, int price, double basePowerConsumption, int vramSize, boolean hasRayTracing, double clockSpeed){
        super(brand, model, price, basePowerConsumption);
        this.vramSize = vramSize;
        this.hasRayTracing = hasRayTracing;
        this.clockSpeed = clockSpeed;
    }
    public GPU(){

    }
    @Override
    public void boostPerformance(double factor){
        if(factor > 1.5){
            this.clockSpeed /= factor;
            this.basePowerConsumption = 15;
        }
        else{
            this.clockSpeed *= factor;
            this.basePowerConsumption *= factor*factor;
            if(this.basePowerConsumption > 500)
                System.out.println("WARNING: Thermal throttling! GPU might be damaged!");
        }
    }
}
