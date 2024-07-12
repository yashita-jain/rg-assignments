import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Optional<String> foundName = findName(names, "Charlie");
        foundName.ifPresent(name -> System.out.println("Found: " + name));

        Optional<String> missingName = findName(names, "Eve");
        System.out.println("Found: " + missingName.orElse("Name not found"));
    }

    public static Optional<String> findName(List<String> names, String searchName) {
        return names.stream()
                .filter(name -> name.equalsIgnoreCase(searchName))
                .findFirst();
    }
}
