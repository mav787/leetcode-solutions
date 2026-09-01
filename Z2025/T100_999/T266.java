package Z2025.T100_999;

public class T266 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        int singles = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] % 2 == 1){
                singles++;
            }
            if(singles > 1){
                return false;
            }
        }

        return true;
    }
}
