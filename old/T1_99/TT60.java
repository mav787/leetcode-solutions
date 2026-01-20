package old.T1_99;
import java.util.*;

public class TT60 {
	public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) 
            list.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) 
            fact[i] = i * fact[i - 1];
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--){
            int index = k / fact[i];
            k = k % fact[i];
            sb.append(list.get(index));
            list.remove(index);		// in a permutation, one letter is used once
        }
        return sb.toString();
    }
}
