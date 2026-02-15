package com.angelagomez.reto5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CoffeeSystemTest {

    @Test
    void baseCoffeeShouldHaveCorrectPrice() {
        Coffee coffee = new BaseCoffee();
        assertEquals(2000, coffee.getPrice());
    }

    @Test
    void baseCoffeeShouldHaveCorrectDescription() {
        Coffee coffee = new BaseCoffee();
        assertEquals("Basic Coffee", coffee.getDescription());
    }

    @Test
    void milkShouldIncreasePrice() {
        Coffee coffee = new MilkTopping(new BaseCoffee());
        assertEquals(3000, coffee.getPrice());
    }

    @Test
    void milkShouldModifyDescription() {
        Coffee coffee = new MilkTopping(new BaseCoffee());
        assertTrue(coffee.getDescription().contains("Milk"));
    }

    @Test
    void chocolateShouldIncreasePrice() {
        Coffee coffee = new ChocolateTopping(new BaseCoffee());
        assertEquals(3500, coffee.getPrice());
    }

    @Test
    void multipleToppingsShouldAccumulatePrice() {
        Coffee coffee = new BaseCoffee();
        coffee = new MilkTopping(coffee);      
        coffee = new ChocolateTopping(coffee); 

        assertEquals(4500, coffee.getPrice());
    }

    @Test
    void multipleToppingsShouldAccumulateDescription() {
        Coffee coffee = new BaseCoffee();
        coffee = new MilkTopping(coffee);
        coffee = new ChocolateTopping(coffee);

        String description = coffee.getDescription();

        assertTrue(description.contains("Basic Coffee"));
        assertTrue(description.contains("Milk"));
        assertTrue(description.contains("Chocolate"));
    }

    @Test
    void customToppingShouldAddCustomPrice() {
        Coffee coffee = new BaseCoffee();
        coffee = new ModifyTopping(coffee, "Almond", 1800);

        assertEquals(3800, coffee.getPrice());
    }

    @Test
    void customToppingShouldAddCustomName() {
        Coffee coffee = new BaseCoffee();
        coffee = new ModifyTopping(coffee, "Almond", 1800);

        assertTrue(coffee.getDescription().contains("Almond"));
    }

    @Test
    void orderShouldCalculateTotalUsingStream() {
        Coffee coffee1 = new MilkTopping(new BaseCoffee());       
        Coffee coffee2 = new ChocolateTopping(new BaseCoffee());  

        Order order = new Order();
        order.addCoffee(coffee1);
        order.addCoffee(coffee2);

        assertEquals(6500, order.getTotal());
    }
}
