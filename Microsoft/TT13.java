package Microsoft;

public class TT13 {
	public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        int[] arr = new int[s.length()];
        for(int i = 0; i < arr.length; i++){
            switch(s.charAt(i)){
                case 'M':
                    arr[i] = 1000;
                    break;
                case 'D':
                    arr[i] = 500;
                    break;
                case 'C':
                    arr[i] = 100;
                    break;
                case 'L':
                    arr[i] = 50;
                    break;
                case 'X':
                    arr[i] = 10;
                    break;
                case 'V':
                    arr[i] = 5;
                    break;
                case 'I':
                    arr[i] = 1;
                    break;
            }
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] < arr[i + 1]){
                res -= arr[i];
            }
            else{
                res += arr[i];
            }
        }
        res += arr[arr.length - 1];
        return res;
    }
}
