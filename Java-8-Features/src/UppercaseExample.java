import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Convert names to uppercase using map
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Print the converted names
        System.out.println("Uppercase Names: " + uppercaseNames);
    }
}
