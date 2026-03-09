import java.util.*;
import java.io.*;

public class Main {

    public static ArrayList<Car> loadCars(String file) {

        ArrayList<Car> cars = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine(); // skip header

            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split(",");

                if (p.length == 7) {

                    int id = Integer.parseInt(p[0].substring(1)); // remove C
                    String brand = p[1];
                    String model = p[2];
                    int year = Integer.parseInt(p[3]);
                    String fuel = p[4];
                    String color = p[5];
                    double mileage = Double.parseDouble(p[6]);

                    Car car = new Car(id, brand, model, year, fuel, color, mileage);

                    cars.add(car);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("File error");
        }

        System.out.println("Cars loaded: " + cars.size());
        return cars;
    }

    // Selection Sort by Brand
    public static void sortBrand(ArrayList<Car> cars) {

        for (int i = 0; i < cars.size() - 1; i++) {

            int min = i;

            for (int j = i + 1; j < cars.size(); j++) {

                if (cars.get(j).getBrand()
                        .compareToIgnoreCase(cars.get(min).getBrand()) < 0) {

                    min = j;
                }
            }

            Car temp = cars.get(i);
            cars.set(i, cars.get(min));
            cars.set(min, temp);
        }

        System.out.println("\nFirst 10 cars:");

        for (int i = 0; i < 10 && i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
    }

    // Binary Search by Brand
    public static int binarySearch(ArrayList<Car> cars, String brand) {

        int low = 0;
        int high = cars.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = cars.get(mid)
                    .getBrand()
                    .compareToIgnoreCase(brand);

            if (cmp == 0)
                return mid;

            if (cmp < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    // Stats
    public static void stats(ArrayList<Car> cars) {

        int gas = 0;
        int diesel = 0;
        int electric = 0;
        int hybrid = 0;

        double total = 0;

        for (Car c : cars) {

            total += c.getMileage();

            String f = c.getFuelType().toLowerCase();

            if (f.equals("gas"))
                gas++;

            else if (f.equals("diesel"))
                diesel++;

            else if (f.equals("electric"))
                electric++;

            else if (f.equals("hybrid"))
                hybrid++;
        }

        System.out.println("\nAverage Mileage: " + (total / cars.size()));

        System.out.println("Fuel Counts:");
        System.out.println("Gas: " + gas);
        System.out.println("Diesel: " + diesel);
        System.out.println("Electric: " + electric);
        System.out.println("Hybrid: " + hybrid);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Car> cars = loadCars("Car_Data.csv");

        while (true) {

            System.out.println("\n1 Sort by Brand");
            System.out.println("2 Search by Brand");
            System.out.println("3 Stats");
            System.out.println("4 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                sortBrand(cars);
            }

            else if (choice == 2) {

                System.out.print("Enter brand: ");
                String brand = sc.nextLine();

                sortBrand(cars);

                int index = binarySearch(cars, brand);

                if (index != -1)
                    System.out.println("\nFound: " + cars.get(index));
                else
                    System.out.println("Brand not found");
            }

            else if (choice == 3) {

                stats(cars);
            }

            else if (choice == 4) {

                System.out.println("Goodbye");
                break;
            }
        }
    }
}
