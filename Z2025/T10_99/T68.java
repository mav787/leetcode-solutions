package Z2025.T10_99;
import java.util.*;

public class T68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // 1. fill
        // 2. massage
        //      2.1 massage lines
        //      2.2 massage single-word line & last line
        List<String> list = new ArrayList<>();

        if(words == null || words.length == 0){
            return list;
        }

        fill(list, words, maxWidth);

        List<String> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if (i != list.size() - 1 && list.get(i).trim().contains(" ")) {
                res.add(massage(list.get(i), maxWidth));
            } else {
                String s = list.get(i);
                StringBuilder sb = new StringBuilder(s);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());
            }
        }

        return res;
    }

    private void fill(List<String> list, String[] words, int maxWidth){
        int i = 0;
        int line = 0;
        StringBuilder sb = new StringBuilder();

        while(i < words.length){
            if(line + words[i].length() > maxWidth){
                list.add(sb.toString());
                sb = new StringBuilder();
                line = 0;
            }

            line += words[i].length();
            sb.append(words[i]);

            if(line != maxWidth){
                line += 1;
                sb.append(" ");
            }
            i++;
        }

        if(line != 0){
            list.add(sb.toString());
        }
    }

    private String massage(String s, int maxWidth){
        String[] sa = s.split(" ");
        StringBuilder[] sbs = new StringBuilder[sa.length];
        StringBuilder sb = new StringBuilder();

        if(sa.length == 1){
            sb.append(sa[0]);
            while(sb.length() < maxWidth){
                sb.append(" ");
            }
            return sb.toString();
        }

        int len = 0;
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder(sa[i]);
            len += sa[i].length();
        }

        int index = 0;
        while(len < maxWidth){
            if(index != sbs.length - 1){
                sbs[index].append(" ");
                len++;
            }
            index = (index + 1) % sbs.length;
        }


        for(int i = 0; i < sbs.length; i++){
            sb.append(sbs[i]);
        }

        return sb.toString();
    }
}
