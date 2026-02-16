package com.angelagomez.reto3;

public class Sailboat extends AbstractVehicle {


    public Sailboat (CategoryStrategy category) {
        super(1000000, 200, category, VehicleType.LAND, "Standard sailboat equipment");

    }

}
