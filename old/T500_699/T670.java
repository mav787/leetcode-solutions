package old.T500_699;

public class T670 {
	public int maximumSwap(int num) {
        if(num < 10) return num;
        int[] arr = new int[9]; // range
        int i = 0;
        int dup = num;
        
        while(num != 0){
            arr[i] = num % 10;
            num /= 10;
            i++;
        }
        
        i--;
        int len = i;
        
        // reversed..
        while(i > 0){
            if(arr[i] >= arr[i - 1]){
                i--;
            }
            else{
                break;
            }
        }
        
        if(i == 0) return dup;
        
        int index = i - 1;
        for(int j = i - 1; j >= 0; j--){
            if(arr[j] >= arr[index]){
                index = j;
            }
        }
        
        int j = len;
        for(j = len; j >= 0; j--){
            if(arr[j] < arr[index]){
                break;
            }
        }
        
        int temp = arr[j];
        arr[j] = arr[index];
        arr[index] = temp;
        
        int res = 0;
        for(int k = len; k >= 0; k--){
            res = res * 10 + arr[k];
        }
        
        return res;
    }
}
