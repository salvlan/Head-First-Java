import java.util.*;
import java.util.stream.*;

public class LimitWithStream {
    public static void main(String[] args) {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        List<String> result = strings.stream()
                .sorted((s1,s2)->s1.compareToIgnoreCase(s2))
                .skip(2)
                .limit(4)
                .collect(Collectors.toList());

        System.out.println("Strings: " + strings);
        System.out.println("Result: " + result);
    }
}