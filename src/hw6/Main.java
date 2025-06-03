package hw6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vocab vocab = new Vocab("test_vocab");
        Scanner sc = new Scanner(System.in);
        vocab.addWord(sc);
        vocab.addWordS("apple", "яблуко");
        vocab.addWordS("book", "книга");
        vocab.addWordS("sun", "сонце");

        System.out.println("Vocabulary after adding words:");
        vocab.printVocabulary();

        vocab.removeWord("book");

        System.out.println("\nVocabulary after removing 'book':");
        vocab.printVocabulary();

        try {
            vocab.saveVocabularyToFile();
        } catch (IOException e) {
            System.out.println("Error saving vocabulary: " + e.getMessage());
        }

        Vocab loadedVocab = new Vocab("test_vocab");
        try {
            File file = new File("test_vocab.txt");
            loadedVocab.loadFromFile(file);
            System.out.println("\nVocabulary loaded from file:");
            loadedVocab.printVocabulary();
        } catch (IOException e) {
            System.out.println("Error loading vocabulary: " + e.getMessage());
        }
    }
}
