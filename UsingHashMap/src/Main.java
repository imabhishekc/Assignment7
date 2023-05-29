import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class UsingHash {
    String chars = "abcdefghi";
    Random random = new Random();
    Map<String, String> urlMap = new HashMap<>();

    public void fillUrls() {
        for (int i = 0; i <= 1000; i++) {
            String originalUrl = generateOriginalUrl();
            if (!urlMap.containsKey(originalUrl)) {
                String shortenedUrl = generateUrl();
                urlMap.put(originalUrl, shortenedUrl);
            }
        }
    }

    public String generateOriginalUrl() {
        return "https://www.youtube.com/channel/UCC8R7JrHPRLJ45kL98YACgw";
    }

    public String generateUrl() {
        StringBuilder strb = new StringBuilder();
        int index;
        strb.setLength(0);

        for (int i = 0; i < 6; i++) {
            index = random.nextInt(chars.length());
            strb.append(chars.charAt(index));
        }

        return strb.toString();
    }

    public String getShortenedUrl(String originalUrl) {
        return urlMap.get(originalUrl);
    }

    public void addUrl(String originalUrl, String shortenedUrl) {
        urlMap.put(originalUrl, shortenedUrl);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String oUrl = "https://www.youtube.com/channel/UCC8R7JrHPRLJ45kL98YACgw";
        oUrl = "https://www.youtube.com/@Telusko/streams";
        String sUrl = "";

        UsingHash service = new UsingHash();

        service.fillUrls();

        sUrl = service.getShortenedUrl(oUrl);
        if (sUrl == null) {
            sUrl = service.generateUrl();
            service.addUrl(oUrl, sUrl);
        }

        System.out.println("Original URL: " + oUrl);
        System.out.println("Shortened URL: " + sUrl);
    }
}
