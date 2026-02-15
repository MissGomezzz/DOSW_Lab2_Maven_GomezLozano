package com.angelagomez.reto5;


public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getPrice() {
        return coffee.getPrice();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}




