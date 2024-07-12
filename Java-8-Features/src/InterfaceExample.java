// Define an interface with a default method and a static method
interface Vehicle {
    // Abstract method
    void start();

    // Default method
    default void honk() {
        System.out.println("Default honk: Beep beep!");
    }

    // Static method
    static void showType() {
        System.out.println("This is a Vehicle interface.");
    }
}

// Implementing the interface in a class
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    // Optionally override the default method
    @Override
    public void honk() {
        System.out.println("Car honk: Honk honk!");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();   // Calls the overridden method
        car.honk();    // Calls the overridden default method

        // Calling the static method from the interface
        Vehicle.showType(); // Calls the static method
    }
}
