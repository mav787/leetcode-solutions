package T100_199;

public class T168 {
	public String convertToTitle(int n) {
        if(n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
