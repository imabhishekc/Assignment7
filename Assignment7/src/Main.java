import java.util.*;

class UrlService {
    String chars = "abcdefghi";
    Random random = new Random();
    List<String> urls = new ArrayList<>();

    public void fillUrls() {
        for (int i = 0; i <= 1000; i++) {
            urls.add(generateUrl());
        }
    }

    public String generateUrl() {
        StringBuilder sb = new StringBuilder();
        int index;
        sb.setLength(0);

        for (int i = 0; i < 6; i++) {
            index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String oUrl = "https://www.youtube.com/channel/UCC8R7JrHPRLJ45kL98YACgw";
        String sUrl = "";

        UrlService service = new UrlService();

        service.fillUrls();

        do {
            sUrl = service.generateUrl();
            System.out.println("Created: " + sUrl);
        } while (service.urls.contains(sUrl));

        System.out.println("Original URL: " + oUrl);
        System.out.println("Shortened URL: " + sUrl);
    }
}












































