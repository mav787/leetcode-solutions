package old.T300_499;
import java.util.*;
public class T465 {
	public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        List<Integer> amount = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k) != 0) amount.add(map.get(k));
        }

        int matches = removeExactMatches(amount);
        return matches + backtrack(0, amount);
    }

    private int removeExactMatches(List<Integer> amount) {
        Collections.sort(amount);
        int l = 0, r = amount.size() - 1;
        int matches = 0;
        while (l < r) {
            if (amount.get(l) + amount.get(r) == 0) {
                amount.remove(l);
                amount.remove(r - 1);
                r -= 2;
                matches++;
            } else if (amount.get(l) + amount.get(r) > 0) {
                r--;
            } else {
                l++;
            }
        }

        return matches;
    }

    private int backtrack(int index, List<Integer> amount) {
        while (index < amount.size() && amount.get(index) == 0) {
        	index++;
        }
        if (index == amount.size()) return 0;
        
        int res = Integer.MAX_VALUE;
        for (int i = index + 1; i < amount.size(); i++) {
            if ((long) amount.get(i) * amount.get(index) < 0) {
                amount.set(i, amount.get(i) + amount.get(index));
                
                int next = backtrack(index + 1, amount);
                res = Math.min(res, next + 1);
                
                amount.set(i, amount.get(i) - amount.get(index));
            }
        }
        return res;
    }
}
