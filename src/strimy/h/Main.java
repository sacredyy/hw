package strimy.h;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file = new File("sites.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> urls = br.lines()
                    .filter(url -> !url.isEmpty())
                    .filter(url -> {
                        try {
                            return NetService.getHeadersFromURL(url);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (URISyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
            urls.stream()
                    .forEach(x -> System.out.println(x + " - is available webpage"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
