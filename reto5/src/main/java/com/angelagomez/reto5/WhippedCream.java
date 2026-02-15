package com.angelagomez.reto5;

public class WhippedCream extends CoffeeDecorator {

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Whipped cream";
    }
}


