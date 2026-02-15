package com.angelagomez.reto3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Use of method readOption guided with ChatGPT for easier understanding of the flow and logic
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Welcome to the Kingdom of Vehicles!");

        while (true) {

            System.out.println(
                    "\nSelect vehicle type:\n" +
                    "1. LAND\n" +
                    "2. WATER\n" +
                    "3. AIR\n" +
                    "0. Finish purchase"
            );

            int typeOption = readOption(scanner, 0, 3);

            if (typeOption == 0) {
                break;
            }

            System.out.println(
                    "\nSelect category:\n" +
                    "1. ECONOMIC\n" +
                    "2. LUXURY\n" +
                    "3. USED"
            );

            int categoryOption = readOption(scanner, 1, 3);

            CategoryStrategy category;

            switch (categoryOption) {
                case 1:
                    category = new EconomicCategory();
                    break;
                case 2:
                    category = new LuxuryCategory();
                    break;
                case 3:
                    category = new UsedCategory();
                    break;
                default:
                    throw new IllegalStateException("Unexpected category value");
            }

            VehicleComponent vehicle = null;

            switch (typeOption) {

                case 1: 
                    System.out.println(
                            "\nSelect LAND vehicle:\n" +
                            "1. Car\n" +
                            "2. Bicycle\n" +
                            "3. Motorcycle"
                    );

                    int landOption = readOption(scanner, 1, 3);

                    switch (landOption) {
                        case 1:
                            vehicle = new Car(category);
                            break;
                        case 2:
                            vehicle = new Bicycle(category);
                            break;
                        case 3:
                            vehicle = new Bike(category);
                            break;
                    }
                    break;

                case 2: 
                    System.out.println(
                            "\nSelect WATER vehicle:\n" +
                            "1. Boat\n" +
                            "2. Sailboat\n" +
                            "3. JetSki"
                    );

                    int waterOption = readOption(scanner, 1, 3);

                    switch (waterOption) {
                        case 1:
                            vehicle = new Boat(category);
                            break;
                        case 2:
                            vehicle = new Sailboat(category);
                            break;
                        case 3:
                            vehicle = new JetSki(category);
                            break;
                    }
                    break;

                case 3: 
                    System.out.println(
                            "\nSelect AIR vehicle:\n" +
                            "1. Airplane\n" +
                            "2. Plane\n" +
                            "3. Helicopter"
                    );

                    int airOption = readOption(scanner, 1, 3);

                    switch (airOption) {
                        case 1:
                            vehicle = new Airplane(category);
                            break;
                        case 2:
                            vehicle = new Plane(category);
                            break;
                        case 3:
                            vehicle = new Helicopter(category);
                            break;
                    }
                    break;
            }

            if (vehicle != null) {
                order.addVehicle(vehicle);
                System.out.println("Vehicle added to your order!");
            }
        }

        System.out.println("\n-------PURCHASE SUMMARY------");
        System.out.println(order.showDetails());
    }

    // Method used to read options 
    private static int readOption(Scanner scanner, int min, int max) {
        int option;

        while (true) {
            System.out.print("Enter option: ");
            String input = scanner.nextLine();

            try {
                option = Integer.parseInt(input);

                if (option < min || option > max) {
                    throw new IllegalArgumentException();
                }

                return option;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Option must be between " + min + " and " + max + ".");
            }
        }
    }
}
