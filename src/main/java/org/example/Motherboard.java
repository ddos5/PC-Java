package org.example;

public class Motherboard extends Component{
    private String socket;
    public Motherboard(String brand, String model, int price, double basePowerConsumption, String socket){
        super(brand, model, price, basePowerConsumption);
        this.socket = socket;
    }
    public Motherboard(){

    }

    public boolean compareSocket(CPU cpu){
        return cpu.getSocket().equals(socket);
    }
}
