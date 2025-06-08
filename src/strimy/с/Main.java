package strimy.c;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\artur\\Documents\\");
        File[] f = directory.listFiles();

        if (f != null) {
            Arrays.stream(f)
                    .max((a, b) -> Long.compare(a.length(), b.length()))
                    .ifPresent(a -> System.out.println(a.getPath()));
        } else {
            System.out.println("Folder is empty");
        }
    }
}
