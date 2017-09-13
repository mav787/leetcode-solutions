package T500_699;

public class T670iii {
	public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int len = s.length();
//        if(len == 1) return num;
        int[] digits = new int[len];
        for(int i = 0; i < len; i++){
            digits[i] = (int)(s.charAt(i) - '0');
        }
        
        int curr = 0;
        while(curr + 1 < len){
            if(digits[curr] >= digits[curr + 1]){
                curr++;
            }
            else{
                break;
            }
        }
        
        if(curr == len - 1) return num;
        
        int index = curr + 1;
        for(int i = index; i < len; i++){
            if(digits[i] >= digits[index]){
                index = i;
            }
        }
        
        curr = 0;
        for(; curr < len; curr++){
            if(digits[curr] < digits[index]){
                break;
            }
        }
        
        swap(digits, curr, index);
        return toNum(digits);
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private int toNum(int[] arr){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            res = res * 10 + arr[i];
        }
        return res;
    }
}
