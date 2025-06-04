package hw8;

import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static hw8.NetService.getLinksFromUrl;

public class Main {
    public static void main(String[] args) {
        String spec = "https://dou.ua/";
        String outputFile = "links.txt";
        try {
            List<String> links = getLinksFromUrl(spec, "UTF-8");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String link : links) {
                    writer.write(link);
                    writer.newLine();
                }
                System.out.println("succes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}