package com.angelagomez.reto3;

public class Airplane extends AbstractVehicle {

    public Airplane (CategoryStrategy category) {
                super(1000000, 200, category, VehicleType.AIR, "Standard car equipment");
    }
}
