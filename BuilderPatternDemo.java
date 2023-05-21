// Product class
class Car {
    private String make;
    private String model;
    private int year;
    private String color;

    public Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}

// Builder interface
interface CarBuilder {
    CarBuilder setMake(String make);
    CarBuilder setModel(String model);
    CarBuilder setYear(int year);
    CarBuilder setColor(String color);
    Car build();
}

// Concrete builder
class CarBuilderImpl implements CarBuilder {
    private String make;
    private String model;
    private int year;
    private String color;

    @Override
    public CarBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    @Override
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public Car build() {
        return new Car(make, model, year, color);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();

        Car car1 = carBuilder.setMake("Toyota")
                             .setModel("Camry")
                             .setYear(2021)
                             .setColor("Silver")
                             .build();

        Car car2 = carBuilder.setMake("Ford")
                             .setModel("Mustang")
                             .setYear(2022)
                             .setColor("Red")
                             .build();

        System.out.println(car1);
        System.out.println(car2);
    }
}
