package hw4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("/home/kevin/test1");
        File target = new File("/home/kevin/testTarget");
        String ext;
        try (Scanner sc = new Scanner(System.in)){
            System.out.print("Enter extention of file: ");
            ext = sc.nextLine();
        }
        try {
            System.out.println(FileService.transferFile(file, target, ext));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
