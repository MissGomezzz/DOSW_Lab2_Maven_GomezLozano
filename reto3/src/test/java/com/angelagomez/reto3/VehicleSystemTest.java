package com.angelagomez.reto3;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleSystemTest {

    private Car economicCar;
    private Car luxuryCar;
    private Bike luxuryBike;
    private Boat usedBoat;

    @BeforeEach
    void setUp() {
        economicCar = new Car(new EconomicCategory());
        luxuryCar = new Car(new LuxuryCategory());
        luxuryBike = new Bike(new LuxuryCategory());
        usedBoat = new Boat(new UsedCategory());
    }

    @Test
    void luxuryCarShouldCostMoreThanEconomicCar() {
        assertTrue(luxuryCar.getPrice() > economicCar.getPrice());
    }

    @Test
    void usedBoatShouldBeCheaperThanLuxuryCar() {
        assertTrue(usedBoat.getPrice() < luxuryCar.getPrice());
    }

    @Test
    void luxuryBikeShouldBeFasterThanEconomicCar() {
        assertTrue(luxuryBike.getSpeed() > economicCar.getSpeed());
    }

    @Test
    void economicCategoryShouldReducePrice() {
        EconomicCategory economic = new EconomicCategory();
        assertEquals(900, economic.calculatePrice(1000));
    }

    @Test
    void luxuryCategoryShouldIncreasePrice() {
        LuxuryCategory luxury = new LuxuryCategory();
        assertEquals(1200, luxury.calculatePrice(1000));
    }

    @Test
    void usedCategoryShouldReducePriceMore() {
        UsedCategory used = new UsedCategory();
        assertEquals(750, used.calculatePrice(1000));
    }

    @Test
    void luxuryCategoryShouldIncreaseSpeed() {
        LuxuryCategory luxury = new LuxuryCategory();
        assertEquals(140, luxury.modifySpeed(100));
    }

    @Test
    void equipmentShouldIncludeCategoryExtras() {
        String equipment = luxuryCar.getEquipment();
        assertTrue(equipment.contains("emergency kit"));
    }

    @Test
    void shouldFilterExpensiveVehiclesUsingStream() {

        List<AbstractVehicle> vehicles =
                List.of(economicCar, luxuryCar, luxuryBike, usedBoat);

        List<AbstractVehicle> expensive = vehicles.stream()
                .filter(v -> v.getPrice() > 500000)
                .toList();

        assertTrue(expensive.size() > 0);
    }

    @Test
    void shouldFindFastestVehicle() {

        List<AbstractVehicle> vehicles =
                List.of(economicCar, luxuryCar, luxuryBike, usedBoat);

        AbstractVehicle fastest = vehicles.stream()
                .max((v1, v2) -> Integer.compare(v1.getSpeed(), v2.getSpeed()))
                .orElse(null);

        assertNotNull(fastest);
    }

    @Test
    void shouldCalculateTotalPrice() {

        List<AbstractVehicle> vehicles =
                List.of(economicCar, luxuryCar, luxuryBike, usedBoat);

        double total = vehicles.stream()
                .mapToDouble(AbstractVehicle::getPrice)
                .sum();

        assertTrue(total > 0);
    }
}
