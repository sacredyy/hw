package strimy.h;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class NetService {
    public static boolean getHeadersFromURL(String spec) throws IOException, URISyntaxException, IOException, URISyntaxException {
        URI uri = new URI(spec);
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();
        if (connection.getHeaderFields() != null && connection.getHeaderFields().size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
