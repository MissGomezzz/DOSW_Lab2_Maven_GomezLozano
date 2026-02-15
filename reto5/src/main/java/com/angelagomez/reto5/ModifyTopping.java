package com.angelagomez.reto5;


public class ModifyTopping extends CoffeeDecorator {

    private String name;
    private double price;

    public ModifyTopping(Coffee coffee, String name, double price) {
        super(coffee);
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + price;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + " + name;
    }
}
