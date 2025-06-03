package hw5;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("/home/kevin/Documents/IdeaProjects/hw/src/hw5/text.txt");
        try {
            System.out.println(countLetters(file));
            Listsorted(countLetters(file));
            countFrequency(Listsorted(countLetters(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<Character, Integer> countLetters(File file) throws IOException {
        String text = "";
        StringBuilder sb = new StringBuilder(text);
        try (Scanner sc = new Scanner(file)){
            while (sc.hasNextLine() ) {
                sb.append(sc.nextLine());

            }
        }
        String fullText = sb.toString();
        Map<Character, Integer> letterCount = new HashMap<>();

        for (char c : fullText.toCharArray()) {
            c = Character.toLowerCase(c);
            if (c != ' ' && !Character.isDigit(c)){
                Integer count = letterCount.getOrDefault(c, 0);
                letterCount.put(c, count + 1);
            }
        }
        return letterCount;
    }
    public static List<Map.Entry<Character, Integer>> Listsorted(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> listChar = new ArrayList<>(map.entrySet());
        Collections.sort(listChar, new ComparatorForArray());
        return listChar;
    }

    public static void countFrequency(List<Map.Entry<Character, Integer>> map) {
        int totalLetters = 0;
        for (Map.Entry<Character, Integer> s : map) {
           totalLetters += s.getValue();
        }
        for (Map.Entry<Character, Integer> s : map) {
            char letter = s.getKey();
            int count = s.getValue();
            double freq = (double) count / totalLetters * 100;
            System.out.printf("%c : %d (%.2f%%)\n", letter, count, freq);
        }
    }
}
