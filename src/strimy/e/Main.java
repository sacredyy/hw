package strimy.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String mixedText = "Привет Hello, это Test смешанный mixed текст. " +
                "Некоторые Some слова words будут be написаны written вот so. " +
                "Круто Cool, правда? Давайте Let's продолжим continue!";
        String onlyEng = mixedText.chars()
                .filter(w -> (w >= 'A' && w <= 'Z') || (w >= 'a' && w <= 'z') || (w == ' '))
                .mapToObj(w -> String.valueOf((char) w))
                .collect(Collectors.joining());
        System.out.println(onlyEng);

     }
}
