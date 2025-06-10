package strimy.j;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\artur\\Documents\\");
        File[] listOfFiles = folder.listFiles();
        List<String> filesWithTxtExtention = Arrays.stream(listOfFiles)
                .map(s -> s.getName())
                .filter(s -> {
                    return s.endsWith(".txt");
                })
                .collect(Collectors.toList());
        System.out.println(filesWithTxtExtention);
    }
}
