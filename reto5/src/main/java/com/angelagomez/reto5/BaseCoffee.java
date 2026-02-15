package com.angelagomez.reto5;

public class BaseCoffee implements Coffee {

    @Override
    public double getPrice() {
        return 2000;
    }

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }
}


