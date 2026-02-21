package org.example;

import java.util.ArrayList;
import java.util.List;

public class PCBuild implements ComponentAdder{
    private List<Component> components = new ArrayList<>();
    public double calculateTotalPower(){
        double sum = 0;
        for(Component x : components){
            sum += x.getBasePowerConsumption();
        }
        return sum;
    }
    @Override
    public void addComponent(Component c){
        components.add(c);
    }

    public List<Component> getArrayList(){
        return components;
    }
}
