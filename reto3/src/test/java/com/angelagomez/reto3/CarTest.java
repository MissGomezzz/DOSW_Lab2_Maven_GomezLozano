package com.angelagomez.reto3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carShouldReturnModifiedPrice() {
        CategoryStrategy category = new LuxuryCategory();
        Car car = new Car(category);

        double price = car.getPrice();

        assertTrue(price > 0);
    }

    @Test
    void carShouldReturnDetails() {
        CategoryStrategy category = new EconomicCategory();
        Car car = new Car(category);

        String details = car.showDetails();

        assertNotNull(details);
        assertTrue(details.contains("Type"));
    }
}
