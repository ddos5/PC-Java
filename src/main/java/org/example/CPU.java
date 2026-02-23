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
    public void boostPerformance(double factor, PCBuild computer) throws PowerOverloadException{
        if(factor > 1.5) {
            this.frequency = 0.5;
            this.basePowerConsumption /= factor;
        }
        else {
            PowerSupply currentPsu = computer.getPowerSupply();
            double futureCpuPower = this.basePowerConsumption * (factor*1.2);
            double futureTotalPower = (computer.calculateTotalPower() - this.basePowerConsumption) + futureCpuPower;
            if(futureTotalPower > currentPsu.getMaxWattage()){
                throw new PowerOverloadException("OC Failed: PSU limit for CPU reached! Future : " + String.format("%.2f", futureTotalPower) + "W", futureCpuPower);
            }

            this.frequency *= factor;
            this.basePowerConsumption = futureCpuPower;

            if (this.basePowerConsumption > 350)
                System.out.println("WARNING: Thermal throttling! CPU might be damaged!");
        }
    }
    /*getters setters*/

    public int getCores(){
        return cores;
    }
    public void setCores(int cores){
        this.cores = cores;
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
