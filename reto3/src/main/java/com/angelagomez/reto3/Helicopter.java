package com.angelagomez.reto3;

public class Helicopter extends AbstractVehicle {

    public Helicopter (CategoryStrategy category) {
                super(1000000, 200, category, VehicleType.AIR, "Standard helicopter equipment");
    }
}
