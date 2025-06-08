package strimy.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Jerry", 2);
        Cat cat2 = new Cat("Bagira", 2);
        Cat cat3 = new Cat("Belok", 2);
        List<Cat> list = List.of(cat1, cat2, cat3);

        Optional<String> longestName = list.stream()
                .map(Cat::getName)
                .max((a,b) -> Integer.compare(a.length(), b.length()));
        longestName.ifPresent(name -> System.out.println(name));

    }

}
