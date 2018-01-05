package T500_699;

public class T670iii {
	public int maximumSwap(int num) {
        if(num <= 0) return 0;
        String s = String.valueOf(num);
        int len = s.length();
        int[] digits = new int[len];
        for(int i = 0; i < len; i++){
            digits[i] = s.charAt(i) - '0';
        }
        
        int[] maxValues = new int[len];
        int[] indices = new int[len];
        maxValues[len - 1] = digits[len - 1];
        indices[len - 1] = len - 1;
        
        for(int i = len - 2; i >= 0; i--){
            if(digits[i] > maxValues[i + 1]){
                maxValues[i] = digits[i];
                indices[i] = i;
            }
            else{
                maxValues[i] = maxValues[i + 1];
                indices[i] = indices[i + 1];
            }
        }
        
        for(int i = 0; i < len; i++){
            if(maxValues[i] > digits[i]){
                swap(digits, i, indices[i]);
                break;
            }
        }
        int res = 0;
        for(int i = 0; i < len; i++){
            res = res * 10 + digits[i];
        }
        return res;
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
