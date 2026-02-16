package com.angelagomez.reto3;


public class LuxuryCategory implements CategoryStrategy {

    @Override 
    public double calculatePrice(double basePrice) {
        return basePrice * 1.20;
    }

    @Override
    public int modifySpeed (int speed) {
        return speed + 40;
    }

    @Override 
    public String getAdditionalEquipment() {
        return "Has emergency kit, the finest materials for construction and a bigger size";
    }

}


