package FaceBook;

public class T168 {
	public String convertToTitle(int n) {
		if(n <= 0)
			return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
