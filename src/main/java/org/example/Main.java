package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GPU gpu = new GPU("NVIDIA", "RTX 3050", 400, 450, 6, true, 1552);
        CPU cpu = new CPU("Intel", "10400f", 150, 20, 6, 2.9, "LGA1200");
        CPU ryzen = new CPU("AMD", "Ryzen 5900x", 400, 142, 12, 3.7, "AM5");
        Storage ssd = new Storage("Samsung", "970 Evo", 300, 3, 1024, true);
        Motherboard motherboard = new Motherboard("MSI", "MPG Z490", 150, 11, "LGA1200");
        PowerSupply psu = new PowerSupply("Be queit!", "POWER 11", 70);
        psu.setMaxWattage(650);
        PCBuild computer = new PCBuild();

        try{
            computer.setPowerSupply(psu);
            computer.addComponent(gpu);
            computer.addComponent(ssd);
            computer.addComponent(psu);
            computer.addComponent(motherboard);

            if(motherboard.compareSocket(cpu))
                computer.addComponent(cpu);
            else
                computer.addComponent(ryzen);
            gpu.boostPerformance(1.2, computer);
            cpu.boostPerformance(1.15, computer);
            System.out.println("Total power of computer now is: " + computer.calculateTotalPower());
        }catch(PowerOverloadException e){
            System.out.println("Needed PSU for this computer must have " + String.format("%.2f", e.getRequiredPower()) + "W");
            System.out.println("But your PSU limit is only " + psu.getMaxWattage() + "W");
        }




        List<Component> computerarr = computer.getArrayList();
        for(Component c : computerarr){
            if(c instanceof CPU tempCpu) {
                System.out.println(tempCpu.getInfo());
            }
        }


    }
}