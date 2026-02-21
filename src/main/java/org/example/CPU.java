package org.example;

public class CPU extends Component implements Overclockable{
    private int cores;
    private double frequency;
    private String socket;
    public CPU(String brand, String model, int price, double basePowerConsumption, int cores, double frequency, String socket){
        super(brand, model, price, basePowerConsumption);
        this.cores = cores;
        this.frequency = frequency;
        this.socket = socket;
    }
    public CPU(){

    }

    @Override
    public void boostPerformance(double factor){
        if(factor > 1.5) {
            this.frequency = 0.5;
            this.basePowerConsumption /= factor;
        }
        else {
            this.frequency *= factor;
            this.basePowerConsumption *= (factor * 1.2);
            if (this.basePowerConsumption > 350)
                System.out.println("WARNING: Thermal throttling! CPU might be damaged!");
        }
    }

    /*getters setters*/

    public int getCores(){
        return cores;
    }
    public double getFrequency(){
        return frequency;
    }
    public String getSocket(){
        return socket;
    }

    public String getInfo(){
        return "Brand: " + getBrand() + " | Model: " + getModel() + " | Price: " + getPrice() + " | Power cons.: " + String.format("%.2f", basePowerConsumption) + " | Cores: " + cores + " | Frequency: " + String.format("%.2f", frequency) + " | String: " + socket;
    }

}
