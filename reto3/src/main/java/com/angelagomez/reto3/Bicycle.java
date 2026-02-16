package com.angelagomez.reto3;

public class Bicycle extends AbstractVehicle {


    public Bicycle (CategoryStrategy category) {
        super(1000000, 200, category, VehicleType.LAND, "Standard car equipment");

    }

}
