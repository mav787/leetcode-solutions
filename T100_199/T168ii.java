package T100_199;

public class T168ii {
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if(n <= 0) return sb.toString();
        while(n > 0){
            n--;
            sb.insert(0, (char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}
