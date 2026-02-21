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
        computer.addComponent(gpu);
        computer.addComponent(ssd);
        computer.addComponent(psu);
        if(motherboard.compareSocket(cpu))
            computer.addComponent(cpu);
        else
            computer.addComponent(ryzen);
        computer.addComponent(motherboard);
        gpu.boostPerformance(1.2);
        cpu.boostPerformance(1.15);


        List<Component> computerarr = computer.getArrayList();
        for(Component c : computerarr){
            if(c instanceof CPU) {
                CPU tempCpu = (CPU) c;
                System.out.println(tempCpu.getInfo());
            }
        }

        System.out.println("Total power of computer now is: " + computer.calculateTotalPower());
        if(computer.calculateTotalPower() > psu.getMaxWattage())
            System.out.println("SYSTEM FAILURE: PSU overload! Computer turned off.");

    }
}