package com.angelagomez.reto5;

public class MilkTopping extends CoffeeDecorator {

    public MilkTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Milk";
    }
}
