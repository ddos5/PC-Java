package org.example;

public class Storage extends Component{
    private int capacity;
    private boolean isSSD;
    public Storage(String brand, String model, int price, int basePowerConsumption, int capacity, boolean isSSD){
        super(brand, model, price, basePowerConsumption);
        this.capacity = capacity;
        this.isSSD = isSSD;
    }
    public Storage(){

    }
}
