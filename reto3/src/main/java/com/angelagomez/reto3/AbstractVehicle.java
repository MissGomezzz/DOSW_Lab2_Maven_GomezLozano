package com.angelagomez.reto3;

public abstract class AbstractVehicle implements VehicleComponent {

    private final double basePrice;
    private final int baseSpeed;
    private final CategoryStrategy category;
    private final VehicleType vehicleType;
    private final String specialEquipment;

    public AbstractVehicle(double basePrice,
                           int baseSpeed,
                           CategoryStrategy category,
                           VehicleType vehicleType,
                           String specialEquipment) {

        this.basePrice = basePrice;
        this.baseSpeed = baseSpeed; 
        this.category = category;
        this.vehicleType = vehicleType;
        this.specialEquipment = specialEquipment;
    }

    @Override
    public double getPrice() {return category.calculatePrice(basePrice); }

    public int getSpeed() { return category.modifySpeed(baseSpeed); }

    public String getTypeName() {return vehicleType.name(); }

    public String getCategoryName() {
        //Guided with ChatGpt
        return category.getClass().getSimpleName().replace("Category", "");
    }

    public String getEquipment() {
        return specialEquipment + " + " + category.getAdditionalEquipment();
    }

    @Override
    public String showDetails() {
        return "Type: " + getTypeName() +
                "\nCategory: " + getCategoryName() +
                "\nMax Speed: " + getSpeed() + " km/h" +
                "\nPrice: $" + getPrice() +
                "\nEquipment: " + getEquipment();
    }
}
