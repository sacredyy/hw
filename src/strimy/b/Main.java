package strimy.b;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(9,1,2,5,7,9,6,4,2,6,8,0);
        List<Integer> res = list.stream()
                .filter(x -> x % 2 != 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(res);
    }
}
