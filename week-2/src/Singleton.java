public class Singleton {
    // Static variable to hold the single instance of the Singleton class
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Initialization code here
    }

    // Public static method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            // Create the instance if it doesn't exist
            instance = new Singleton();
        }
        return instance;
    }

    // Example method to demonstrate the functionality of the singleton
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        // Get the only instance of Singleton
        Singleton singleInstance = Singleton.getInstance();

        // Call the example method
        singleInstance.showMessage();
    }
}
