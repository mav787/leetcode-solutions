package old.T100_199;

public class T137 {
	//http://fisherlei.blogspot.com/2013/11/leetcode-single-number-ii-solution.html
	public int singleNumber(int[] nums) {
        int[] digitsums = new int[32];
        for(int item: nums){
            encode(item, digitsums);
        }
        
        for(int i = 0; i < 32; i++){
            digitsums[i] %= 3;
        }
        
        return decode(digitsums);
    }
    
    private void encode(int number, int[] digitsums){
        for(int i = 0; i < 32; i++){
            digitsums[i] += (number >> i) & 1;
        }
    }
    
    private int decode(int[] digitsums){
        int res = 0;
        for(int i = 31; i >= 0; i--){
            res <<= 1;
            res += digitsums[i];
        }
        return res;
    }
}
