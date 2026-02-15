package com.angelagomez.reto5;

public class CaramelTopping extends CoffeeDecorator {

    public CaramelTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1200;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Caramel";
    }
}
