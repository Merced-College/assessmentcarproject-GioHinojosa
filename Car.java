public class Car {

    private int id;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private String color;
    private int mileage;

    public Car(int id, String brand, String model, int year, String fuelType, String color, int mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.color = color;
        this.mileage = mileage;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public String toString() {
        return id + " | " + brand + " | " + model + " | " + year + " | " + fuelType + " | " + color + " | " + mileage;
    }
}
