package com.angelagomez.reto3;

public class Plane extends AbstractVehicle {


    public Plane (CategoryStrategy category) {
        super(1000000, 200, category, VehicleType.AIR, "Standard plane equipment");

    }

}
