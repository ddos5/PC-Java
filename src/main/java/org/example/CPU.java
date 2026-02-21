package org.example;

public class CPU extends Component implements Overclockable{
    private int cores;
    private int frequency;
    private int socket;
    public CPU(String brand, String model, int price, double basePowerConsumption, int cores, int frequency, int socket){
        super(brand, model, price, basePowerConsumption);
        this.cores = cores;
        this.frequency = frequency;
        this.socket = socket;
    }
    @Override
    public void boostPerformance(double factor){
        this.basePowerConsumption *= (factor * 1.2);
        if(this.basePowerConsumption > 350)
            System.out.println("WARNING: Thermal throttling! CPU might be damaged!");
    }

}
