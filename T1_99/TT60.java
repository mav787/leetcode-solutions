package T1_99;
import java.util.*;

public class TT60 {
	public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<>();
        for (int i = 1; i <= n; i++) 
            num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) 
            fact[i] = i * fact[i-1];
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--){
            int ind = k / fact[i];
            k = k % fact[i];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
}
