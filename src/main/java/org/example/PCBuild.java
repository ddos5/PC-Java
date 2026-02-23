package org.example;

import java.util.ArrayList;
import java.util.List;

public class PCBuild implements ComponentAdder{
    private List<Component> components = new ArrayList<>();
    private PowerSupply psu;

    public void setPowerSupply(PowerSupply psu){
        this.psu = psu;
    }

    public PowerSupply getPowerSupply(){
        return this.psu;
    }

    public double calculateTotalPower(){
        double sum = 0;
        for(Component x : components){
            sum += x.getBasePowerConsumption();
        }
        return sum;
    }
    @Override
    public void addComponent(Component c) throws PowerOverloadException, IncompatibleSocketException{
        double futurePower = calculateTotalPower() + c.getBasePowerConsumption();
        if (futurePower > psu.getMaxWattage())
            throw new PowerOverloadException("This method creates new exception!", futurePower);

        if(c instanceof CPU newCpu){
            for(Component comp : components){
                if(comp instanceof Motherboard mb)
                    mb.installCpu(newCpu);
            }
        }
        components.add(c);
    }

    public CPU getInstalledCPU(){
        for(Component c : components){
            if(c instanceof CPU neeededCpu)
                return neeededCpu;
        }
        return null;
    }

    public List<Component> getArrayList(){
        return components;
    }
}
