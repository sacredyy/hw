package strimy.f;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Roxi", 2, 4);
        Cat cat2 = new Cat("Jerry", 6, 5);
        Cat cat3 = new Cat("Foxi", 1, 2);
        List<Cat> cats = List.of(cat1, cat2, cat3);
        List<Cat> newCat = cats.stream()
                .filter(w -> w.getWeight() > 3)
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .collect(Collectors.toList());
        System.out.println(newCat);
    }
}
