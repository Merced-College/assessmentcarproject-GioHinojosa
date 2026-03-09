public class Car {

    private int id;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private String color;
    private double mileage;

    public Car(int id, String brand, String model, int year, String fuelType, String color, double mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.color = color;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getMileage() {
        return mileage;
    }

    public String toString() {
        return id + " | " + brand + " | " + model + " | " + year + " | " +
               fuelType + " | " + color + " | " + mileage;
    }
}
