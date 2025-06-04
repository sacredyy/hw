package hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class NetService {

    public static List<String> getLinksFromUrl(String spec, String code) throws IOException, URISyntaxException {
        URI uri = new URI(spec);
        URL url = uri.toURL();
        StringBuilder sb = new StringBuilder();
        URLConnection connection = url.openConnection();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), code))) {
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
        }
        String html = sb.toString();
        List<String> links = new ArrayList<>();
        int start = 0;
        while (true) {
            int hrefStart = html.indexOf("href=\"", start);
            if (hrefStart == -1) break;
            int linkStart = hrefStart + 6;
            int linkEnd = html.indexOf("\"", linkStart);
            if (linkEnd != -1) {
                String link = html.substring(linkStart, linkEnd);
                if (!link.isEmpty() && !link.startsWith("#")) {
                    links.add(link);
                }
            }
            start = linkEnd + 1;
        }
        return links;
    }
}
