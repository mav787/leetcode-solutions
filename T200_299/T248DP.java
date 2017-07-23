package T200_299;

public class T248DP {
	long[] dp;
    char[][] pairs = {{'0','0'},{'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public int strobogrammaticInRange(String low, String high) {
        if (isGreater(low, high)) return 0;
        int len = high.length();
        dp = new long[len+3];
        dp[0] = 1;
        dp[1] = 3;
        dp[2] = 4;
        for (int i = 3; i < dp.length; i++) {
            for (int k = 2; i - k >= 0; k += 2) {
                dp[i] += 4*dp[i-k];
            }
        }
        long result = count(high) - count(low);
        if (isStrobo(low)) result++;
        return (int) result;
    }
    
    private boolean isMatch(char a, char b) {
        for (char[] pair : pairs) {
            if (a == pair[0] && b == pair[1]) return true;
        }
        return false;
    }
    
    private boolean isStrobo(String str) {
        int i = 0, j = str.length()-1;
        while (i < j) {
            if (!isMatch(str.charAt(i), str.charAt(j))) return false;
            i++;
            j--;
        }
        if (i == j) return str.charAt(i) == '0' || str.charAt(i) == '8' || str.charAt(i) == '1';
        return true;
    }
    
    long cnt;
    private long count(String high) {
        if (high.equals("0")) return 1;
        long result = 0;
        for (int i = 1; i < high.length(); i++) result += dp[i];
        cnt = 0;
        char[] num = new char[high.length()];
        dfs(high, num, 0);
        return result + cnt;
    }
    
    private void dfs(String high, char[] nums, int index) {
        if (nums.length%2 == 0 && index >= nums.length/2) {
            if (!isGreater(nums, high)) cnt++;
            return;
        }
        if (nums.length%2 == 1 && index == nums.length/2) {
            nums[index] = '0';
            if (!isGreater(nums, high)) cnt++;
            nums[index] = '8';
            if (!isGreater(nums, high)) cnt++;
            nums[index] = '1';
            if (!isGreater(nums, high)) cnt++;
            return;
        }
        for (char[] pair : pairs) {
            if (index == 0 && pair[0] == '0') continue;
            nums[index] = pair[0];
            nums[nums.length-index-1] = pair[1];
            dfs(high, nums, index+1);
            nums[index] = 0;
            nums[nums.length-index-1] = 0;
        }
    }
    
    private boolean isGreater(String a, String b) {
        if (a.length() > b.length()) return true;
        if (a.length() < b.length()) return false;
        return isGreater(a.toCharArray(), b);
    }
    
    private boolean isGreater(char[] a, String b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) return false;
            if (a[i] > b.charAt(i)) return true;
            if (a[i] < b.charAt(i)) return false;
        }
        return false;
    }
}
