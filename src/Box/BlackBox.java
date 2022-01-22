package Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class BlackBox {
    private URLHandler urlHandler;
    String urlStr;

    public BlackBox(URLHandler urlHandler) {
        this.urlHandler = urlHandler;
    }

    public String URL(ArrayList<List<Map<String, String>>> customerInfo, String urlStr) {
        String url_start = null;
        urlStr = this.recursive_method(urlStr);
        if (this.check_ssl(urlStr)) {
            url_start = urlStr.replace("http://", "https://");
        }

        if (customerInfo == null && customerInfo.size() != 0) {

        }
        return url_start;
    }

    public String recursive_method(String url) {
        for(int i = 0; i < url.length(); ++i) {
        }

        return url;
    }

    public boolean check_ssl(String urlSafe) {
        //checking 443 port
        //checking '1' and 'on'(?)
        return urlSafe.toLowerCase(Locale.ROOT).startsWith("https://");
    }
}
