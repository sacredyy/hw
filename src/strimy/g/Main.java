package strimy.g;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "<dependency>\n" +
                "<groupId>junit</groupId>\n" +
                "<artifactId>junit</artifactId>\n" +
                "<version>4.4</version>\n" +
                "<scope>test</scope>\n" +
                "</dependency>\n" +
                "<dependency>\n" +
                "<groupId>org.powermock</groupId>\n" +
                "<artifactId>powermock-reflect</artifactId>\n" +
                "<version>3.2</version>\n" +
                "</dependency>";
        List<String> finalText = Arrays.stream(text.split("\n"))
                .filter(l -> l.startsWith("<groupId>"))
                .map(l -> l.replaceAll("<groupId>", ""))
                .map(l -> l.replaceAll("</groupId>", ""))
                .collect(Collectors.toList());
        System.out.println(finalText);
    }
}
