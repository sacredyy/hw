package hw8;

import java.util.List;

import static hw8.NetService.getLinksFromUrl;

public class Main {
    public static void main(String[] args) {
        String spec = "https://dou.ua/";
        try {
            List<String> links = getLinksFromUrl(spec, "UTF-8");
            System.out.println("links " + links.size());
            for (String link : links) {
                System.out.println(link);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
