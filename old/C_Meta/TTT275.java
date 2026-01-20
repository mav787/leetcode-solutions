package old.C_Meta;

public class TTT275 {
	public int hIndex(int[] citations) {
        // The idea is to search for the first index from the sorted array so that:
        // citations[index] >= length(citations) - index
        
        if(citations == null || citations.length == 0)
            return 0;
        int len = citations.length;
        int left = 0, right = len - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(citations[mid] == len - mid)
                return len - mid;
            else if(citations[mid] < len - mid)
                left = mid;
            else
                right = mid;
        }
        if(citations[left] >= len - left)
            return len - left;
        if(citations[right] >= len - right)
            return len - right;
        return 0;
    }
}
