package hw7;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class NetworkService {
    public static Map<String, List<String>> getHeadersFromURL(String spec) throws IOException, URISyntaxException, IOException, URISyntaxException {
        URI uri = new URI(spec);
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();
        return connection.getHeaderFields();
    }
}
