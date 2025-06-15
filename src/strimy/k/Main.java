package strimy.k;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String someText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when" +
                " an unknown printer took a galley of type and scrambled it to make a type specimen " +
                "book. It has survived not only five centuries, but also the leap into electronic " +
                "typesetting, remaining essentially unchanged. It was popularised in the 1960s with " +
                "the release of Letraset sheets containing Lorem Ipsum passages, and more recently " +
                "with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        List<String> text = Arrays.stream(someText.split(" "))
                .filter(word -> countLetters(word) > 0)
                .sorted((w1, w2) -> Integer.compare(countLetters(w1), countLetters(w2)))
                .collect(Collectors.toList());
        System.out.println(text);


    }

    public static int countLetters(String word) {
        return (int) word.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aoieuy".indexOf(c) != -1)
                .count();
    }
}
