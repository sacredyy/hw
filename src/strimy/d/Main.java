package strimy.d;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of " +
                "type and scrambled it to make a type specimen book.";
        String[] words = text.split(" ");
        List<String> wordList = Arrays.stream(words)
                .filter(word -> word.length() < 5)
                .collect(Collectors.toList());
        String res = String.join(" ", wordList);
        System.out.println(res);
    }
}
