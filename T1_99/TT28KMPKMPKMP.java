package T1_99;

public class TT28KMPKMPKMP {
	public int strStr(String haystack, String needle) {
    	//KMP algorithms
    	if(needle.equals("")) return 0;
    	if(haystack.equals("")) return -1;
    	char[] arr = needle.toCharArray();
    	int[] next = makeNext(arr);
    
    	for(int i = 0, j = 0, end = haystack.length();  i < haystack.length();  ){
    		if(j == -1 || haystack.charAt(i) == arr[j]){
    			j++;
    			i++;
    			if(j == arr.length) 
    			    return i - arr.length;
    		}
    		if(i < end && haystack.charAt(i) != arr[j]) 
    		    j = next[j];
    	}
        return -1;
    }
    
    private int[] makeNext(char[] arr){
    	int len = arr.length;
    	int[] next = new int[len];
    
    	next[0] = -1;
    	for(int i = 0, j = -1; i < len - 1; ){
    		if(j == -1 || arr[i] == arr[j]){
    			next[i + 1] = j + 1;
    			if(arr[i + 1] == arr[j + 1]) 
    				next[i + 1] = next[j + 1];
    			i++;
    			j++;
    		}
    		if(arr[i] != arr[j]) 
    			j = next[j];
    	}
    
    	return next;
    }
}
