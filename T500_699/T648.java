package T500_699;
import java.util.*;
public class T648 {
	public String replaceWords(List<String> dict, String sentence) {
        if(dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0)
            return sentence;
        Set<String> set = new HashSet<>(dict);
        String[] sa = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : sa){
            boolean isReplaced = false;
            for(int i = 0; i <= s.length(); i++){
                if(set.contains(s.substring(0, i))){
                    sb.append(s.substring(0, i)).append(" ");
                    isReplaced = true;
                    break;
                }
            }
            if(!isReplaced){
                sb.append(s).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
