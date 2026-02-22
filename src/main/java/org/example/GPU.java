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
    public void boostPerformance(double factor, PCBuild computer) throws PowerOverloadException{
        if(factor > 1.5){
            this.clockSpeed /= factor;
            this.basePowerConsumption = 15;
        }
        else{
            double futurePower = this.basePowerConsumption * (factor * factor);
            double futureClockSpeed = this.clockSpeed * factor;
            double futureTotalPower = (computer.calculateTotalPower() - this.basePowerConsumption) + futurePower;
            PowerSupply currentPsu = computer.getPowerSupply();
            if(futureTotalPower > currentPsu.getMaxWattage()){
                throw new PowerOverloadException("OC Failed: PSU limit for GPU reached! Future: " + String.format("%.2f", futureTotalPower) + "W", futureTotalPower);
            }
            this.clockSpeed *= factor;
            this.basePowerConsumption *= futureClockSpeed;
            if(this.basePowerConsumption > 500)
                System.out.println("WARNING: Thermal throttling! GPU might be damaged!");
        }
    }
}
