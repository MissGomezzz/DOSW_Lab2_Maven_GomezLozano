package com.angelagomez.reto3;

public class UsedCategory implements CategoryStrategy {

    @Override 
    public double calculatePrice(double basePrice) {
        return basePrice * 0.75;
    }

    @Override
    public int modifySpeed (int speed) {
        return speed - 30;
    }

    @Override 
    public String getAdditionalEquipment() {
        return "Has emergency kit";
    }

}
