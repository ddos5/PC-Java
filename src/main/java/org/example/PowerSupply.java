package org.example;

public class PowerSupply extends Component{
    private int maxWattage;
    public PowerSupply(String brand, String model, int price){
        super(brand, model, price);
    }
    public int getMaxWattage(){
        return maxWattage;
    }
    public void setMaxWattage(int maxWattage){
        this.maxWattage = maxWattage;
    }
}
