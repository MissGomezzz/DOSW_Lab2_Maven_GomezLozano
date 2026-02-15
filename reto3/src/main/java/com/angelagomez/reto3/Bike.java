package com.angelagomez.reto3;


public class Bike extends AbstractVehicle {

    public Bike (CategoryStrategy category) {
                super(1000000, 200, category, VehicleType.LAND, "Standard car equipment");
    }
}
