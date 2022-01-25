package Box;

import java.util.*;

public class BlackBox {
    private URLController urlHandler;
    String urlStr;

    public BlackBox(URLController urlHandler) {
        this.urlHandler = urlHandler;
    }

    public String URL(ArrayList<List<Map<String, String>>> customerInfo, String urlStr) {
        if (customerInfo == null || customerInfo.size() == 0) {
            return null;
        }

        String url_start = recursive_method(urlStr);

        if (check_ssl(urlStr)) {
            url_start = urlStr.replace("http://", "https://");
        }

        for(int i = 0; i< customerInfo.size(); i++) {
            System.out.println(customerInfo.get(0));
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
