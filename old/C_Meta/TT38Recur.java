package old.C_Meta;

public class TT38Recur {
	public String countAndSay(int n) {
        if(n < 0)
            return "";
        if(n == 1)
            return "1";
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char curr = pre.charAt(0);
        for(int i = 1; i < pre.length(); i++){
            if(pre.charAt(i) == pre.charAt(i - 1))
                count++;
            else{
                sb.append(count).append(curr);
                count = 1;
                curr = pre.charAt(i);
            }
        }
        sb.append(count).append(curr);
        return sb.toString();
    }
}
