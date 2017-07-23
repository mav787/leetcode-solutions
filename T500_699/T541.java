package T500_699;

public class T541 {
	public String reverseStr(String s, int k) {
        if(s == null || s.length() == 0)
            return s;
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < s.length()){
            int j = Math.min(i + k - 1, s.length() - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    
    private void swap(char[] arr, int left, int right){
        while(left <= right){
            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;
            left++;
            right--;
        }
    }
}
