package com.angelagomez.reto5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.print("Number of coffees to personalize: ");
        int numberOfCoffees = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 1; i <= numberOfCoffees; i++) {

            System.out.println("\n--- Coffee " + i + " ---");
            Coffee coffee = new BaseCoffee();

            showMenu();

            System.out.print("Add number toppings (number separated by commas): ");
            String input = scanner.nextLine();

            String[] options = input.split(",");

            for (String option : options) {

                switch (option.trim()) {

                    case "1":
                        coffee = new MilkTopping(coffee);
                        break;

                    case "2":
                        coffee = new ChocolateTopping(coffee);
                        break;

                    case "3":
                        coffee = new CaramelTopping(coffee);
                        break;

                    case "4":
                        coffee = new WhippedCream(coffee);
                        break;

                    case "5":
                        coffee = new MintTopping(coffee);
                        break;

                    case "6":
                        System.out.print("Enter new name of topping: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter new price of topping: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        coffee = new ModifyTopping(coffee, name, price);
                        break;

                    default:
                        System.out.println("Invalid option");
                }
            }

            order.addCoffee(coffee);
        }

        printSummary(order);
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nToppings available :");
        System.out.println("1. Milk ($1000)");
        System.out.println("2. Chocolate ($1500)");
        System.out.println("3. Caramel ($1200)");
        System.out.println("4. Whipped cream ($2000)");
        System.out.println("5. Mint ($1300)");
        System.out.println("6. Add new topping");
    }

    private static void printSummary(Order order) {

        System.out.println("\n--- SUMMARY OF COFFEE ORDER ---");

        int count = 1;

        for (Coffee coffee : order.getCoffees()) {

            System.out.println("\nBasic coffee " + count + ":");
            System.out.println("Ingredients: " + coffee.getDescription());
            System.out.println("Total price: $" + coffee.getPrice());

            count++;
        }

        System.out.println("\n--------------------------------------");
        System.out.println("Total for all the coffees: $" + order.getTotal());
        System.out.println("Enjoy the coffee!");
    }
}
