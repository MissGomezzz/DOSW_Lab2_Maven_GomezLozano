package com.angelagomez.reto5;

public class ChocolateTopping extends CoffeeDecorator {

    public ChocolateTopping(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1500;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Chocolate";
    }
}
