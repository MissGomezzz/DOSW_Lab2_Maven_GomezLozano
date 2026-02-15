package com.angelagomez.reto3;

public class EconomicCategory implements CategoryStrategy{
    
    @Override 
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9;
    }

    @Override
    public int modifySpeed (int speed) {
        return speed - 20;
    }

    @Override 
    public String getAdditionalEquipment() {
        return "Has emergency kit";
    }

}
