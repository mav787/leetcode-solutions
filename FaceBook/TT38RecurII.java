package FaceBook;

public class TT38RecurII {
	public String countAndSay(int n) {
        if(n <= 0) return "";
        return countAndSay("1", n);
    }
    
    private String countAndSay(String prev, int n){
        if(n == 1) return prev;
        StringBuilder sb = new StringBuilder();
        char curr = prev.charAt(0);
        int count = 1;
        for(int i = 1; i < prev.length(); i++){
            if(prev.charAt(i) == prev.charAt(i - 1)){
                count++;
            }
            else{
                sb.append(count).append(curr);
                curr = prev.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(curr);
        return countAndSay(sb.toString(), n - 1);
    }
}
