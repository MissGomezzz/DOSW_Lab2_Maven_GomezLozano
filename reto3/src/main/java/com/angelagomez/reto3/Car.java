package com.angelagomez.reto3;

public class Car extends AbstractVehicle {

    public Car (CategoryStrategy category) {
        super(1000000, 200, category, VehicleType.LAND, "Standard car equipment");

    }

}
