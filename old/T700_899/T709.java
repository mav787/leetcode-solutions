package old.T700_899;

public class T709 {
	public String toLowerCase(String str) {
        if(str == null) return str;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.append((char)(c - 'A' + 'a'));
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
