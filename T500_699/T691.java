package T500_699;
import java.util.*;
public class T691 {
	
	private Map<Pair , Integer> dp = new HashMap<>();
	
    public int minStickers(String[] stickers, String target) {
        
    	char[] array = target.toCharArray();
    	Arrays.sort(array);
    	dp.clear();
    	return dfs(getList(stickers) , 0 , new String(array));
    	
    }
    
    private int[] getArray(String string) {
    
    	int i , length = string.length();
    	int[] ans = new int[26];
    	for (i = 0;i < length;i ++) {
    		int index = string.charAt(i) - 'a';
    		ans[index] ++;
    	}
    	return ans;
    	
    }
    
    private String getString(int[] array) {
    	
    	StringBuilder builder = new StringBuilder();
    	int i , j , n = array.length;
    	for (i = 0;i < n;i ++) {
    		if (array[i] > 0) {
    			for (j = 0;j < array[i];j ++) {
    				builder.append((char) (i + 'a'));
    			}
    		}
    	}
    	return builder.toString();
    	
    }
    
    private int dfs(List<int[]> stickers , int current , String target) { 
    	
    	if (target.equals("")) {
    		return 0;
    	}
    	if (current == stickers.size()) {
    		return - 1;
    	}
    
    	Pair p = new Pair(current , target);
    	if (dp.containsKey(p)) {
    		return dp.get(p);
    	} else {
    		// not use current one
    		int ans = dfs(stickers , current + 1 , target);
    		
    		int[] array1 = stickers.get(current);
    		int[] array2 = getArray(target);
    		
    		int max = 0;
    		for (int i = 0;i < 26;i ++) {
    			if (array1[i] > 0 && array2[i] > 0) {
    				int temp = array2[i] / array1[i];
    				if (array2[i] % array1[i] != 0) {
    					temp ++;
    				}
    				if (temp > max) {
    					max = temp;
    				}
    			}
    		}
    		
    		for (int i = 0;i < max;i ++) {
    			for (int j = 0;j < 26;j ++) {
    				array2[j] -= array1[j];
    				if (array2[j] < 0) {
    					array2[j] = 0;
    				}
    			}
    			String string = getString(array2);
    			int result = dfs(stickers , current + 1 , string);
    			if (result >= 0) {
    				result += i + 1;
    				if (result < ans || ans < 0) {
    					ans = result;
    				}
    			}
    		}
    		
    		dp.put(p , ans);
    		return ans;
    	}
    	
    }
    
    private List<int[]> getList(String[] stickers) {
		
		List<int[]> ans = new ArrayList<>();
		for (String s : stickers) {
			int[] temp = new int[26];
			for (int i = 0;i < s.length();i ++) {
				int index = s.charAt(i) - 'a';
				temp[index] ++;
			}
			ans.add(temp);
		}
		return ans;
		
	}

    private static class Pair {
		public int position;
		public String target;
		public Pair(int position , String target) {
			this.position = position;
			this.target = target;
		}
		@Override
		public int hashCode() {
			return this.position * 31 + this.target.hashCode();
		}
		@Override
		public boolean equals(Object object) {
			Pair p = (Pair) object;
			return this.position == p.position && this.target.equals(p.target);
		}
	}
	
	
}
