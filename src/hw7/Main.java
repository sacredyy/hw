package hw7;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("sites.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Map<String, List<String>> headers = NetworkService.getHeadersFromURL(line);
                    if (headers != null && headers.size() > 0) {
                        System.out.println(line + " is available");
                    } else {
                        System.out.println(line + " is not available");
                    }
                } catch (IOException | URISyntaxException e) {
                    System.out.println(line + " is not available" + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file sites.txt was not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
