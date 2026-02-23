package org.example;

public class Motherboard extends Component{
    private String socket;
    private PCBuild newCpu;
    public Motherboard(String brand, String model, int price, double basePowerConsumption, String socket){
        super(brand, model, price, basePowerConsumption);
        this.socket = socket;
    }
    public Motherboard(){

    }

    public String getSocket(){
        return socket;
    }

    public void installCpu(CPU cpu) throws IncompatibleSocketException{
        if(!cpu.getSocket().equals(this.socket)){
            throw new IncompatibleSocketException("Your socket is different, needed socket: " + getSocket());
        }
        System.out.println("CPU installed!");
    }
}
