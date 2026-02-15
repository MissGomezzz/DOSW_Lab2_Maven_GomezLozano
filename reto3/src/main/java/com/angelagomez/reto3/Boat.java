package com.angelagomez.reto3;

public class Boat extends AbstractVehicle {

    public Boat (CategoryStrategy category) {
        super(1000000, 200, category, VehicleType.WATER, "Standard boat equipment");

    }

}
