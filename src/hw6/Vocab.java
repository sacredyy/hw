package hw6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vocab {
    private String vocabularyName;
    private final Map<String, String> vocabulary;

    public Vocab(String vocabularyName) {
        this.vocabularyName = vocabularyName;
        vocabulary = new HashMap<>();
    }

    public String getVocabularyName() {
        return vocabularyName;
    }

    public void setVocabularyName(String vocabularyName) {
        this.vocabularyName = vocabularyName;
    }

    public void addWord(Scanner sc) {
        System.out.println("Enter the English word: ");
        String enWord = sc.nextLine().toLowerCase();
        if (vocabulary.containsKey(enWord)) {
            System.out.println("This word is already in the vocabulary");
        } else {
            System.out.println("Now enter translation for this word: ");
            String uaWord = sc.nextLine().toLowerCase();
            vocabulary.put(enWord, uaWord);
            System.out.println("New word successfully added");
        }
    }

    public void addWordS(String enWord, String uaWord) {
        if (vocabulary.containsKey(enWord.toLowerCase())) {
            System.out.println("This word is already in the vocabulary");
        } else {
            vocabulary.put(enWord.toLowerCase(), uaWord.toLowerCase());
        }
    }

    public void removeWord(String englishWord) {
        if (vocabulary.containsKey(englishWord)) {
            vocabulary.remove(englishWord);
            System.out.println("Word successfully removed");
        } else {
            System.out.println("There is no such word in the vocabulary");
        }
    }

    public void saveVocabularyToFile() throws IOException {
        String fileName = vocabularyName.endsWith(".txt") ? vocabularyName : vocabularyName + ".txt";
        File file = new File(fileName);
        try (FileWriter fw = new FileWriter(file)) {
            for (Map.Entry<String, String> s : vocabulary.entrySet()) {
                fw.write(s.getKey() + " - " + s.getValue() + System.lineSeparator());
            }
        }
        System.out.println("Vocabulary saved to: " + file.getAbsolutePath());
    }

    public void loadFromFile(File file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] part = line.split("\\s*-\\s*");
                if (part.length == 2) {
                    addWordS(part[0], part[1]);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        }
    }

    public void printVocabulary() {
        if (vocabulary.isEmpty()) {
            System.out.println("The vocabulary is empty.");
        } else {
            System.out.println("\nCurrent Vocabulary:");
            for (Map.Entry<String, String> entry : vocabulary.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}
