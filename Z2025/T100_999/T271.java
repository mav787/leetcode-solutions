package Z2025.T100_999;

import java.util.*;

public class T271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.replace("#", "##")).append(" # ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        String[] sa = s.split(" # ", -1);
        for(int i = 0; i < sa.length - 1; i++){
            res.add(sa[i].replace("##", "#"));
        }
        return res;
    }

}
