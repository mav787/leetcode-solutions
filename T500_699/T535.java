package T500_699;
import java.util.*;

public class T535 {
    
    List<String> list = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        list.add(longUrl);
        return list.size() - 1 + "";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.parseInt(shortUrl);
        return list.get(index);
    }
}
