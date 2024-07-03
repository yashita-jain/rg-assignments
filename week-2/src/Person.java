public class Person {
    // Private fields to restrict direct access
    private String name;
    private int age;

    // Public constructor to initialize the fields
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public getter method for name
    public String getName() {
        return name;
    }

    // Public setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter method for age
    public int getAge() {
        return age;
    }

    // Public setter method for age
    public void setAge(int age) {
        // Adding validation logic in setter
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive.");
        }
    }

    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("John Doe", 25);

        // Access and modify fields using getter and setter methods
        System.out.println("Name: " + person.getName()); // Output: Name: John Doe
        System.out.println("Age: " + person.getAge());   // Output: Age: 25

        // Modify fields using setter methods
        person.setName("Jane Doe");
        person.setAge(30);

        // Access the modified fields using getter methods
        System.out.println("Updated Name: " + person.getName()); // Output: Updated Name: Jane Doe
        System.out.println("Updated Age: " + person.getAge());   // Output: Updated Age: 30

        // Attempt to set an invalid age
        person.setAge(-5); // Output: Age must be positive.
    }
}
