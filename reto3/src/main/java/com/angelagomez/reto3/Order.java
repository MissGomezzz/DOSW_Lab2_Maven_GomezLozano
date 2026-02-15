package com.angelagomez.reto3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order implements VehicleComponent {

    private final List<VehicleComponent> order; 
    public Order () { 
        order = new ArrayList<>();
    }

    public void addVehicle(VehicleComponent component) { 
        order.add(component);
    }

    public void removeVehicle(VehicleComponent component) {
        order.remove(component);
    }

    @Override
    public double getPrice() {
        // Sum of prices inside list with Streams guided with ChatGPT
        return order.stream()
            .mapToDouble(VehicleComponent::getPrice)
            .sum();
    }

    @Override
    public String showDetails() {

        String vehiclesDetails = order.stream()
                .map(VehicleComponent::showDetails)
                .collect(Collectors.joining("\n---------------------\n"));

        double total = order.stream()
                .mapToDouble(VehicleComponent::getPrice)
                .sum();

        return vehiclesDetails + "\n---------------------\n" + "TOTAL: $" + total;
    }
}

 