package com.angelagomez.reto5;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Coffee> coffees;

    public Order() {
        this.coffees = new ArrayList<>();
    }

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }

    public void removeCoffee(Coffee coffee) {
        coffees.remove(coffee);
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public double getTotal() {
        return coffees.stream()
                .mapToDouble(Coffee::getPrice)
                .sum();
    }
}
