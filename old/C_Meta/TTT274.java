package old.C_Meta;

public class TTT274 {
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for(int i = 0; i < n; i++){
            if(citations[i] > n)
                bucket[n]++;
            else
                bucket[citations[i]]++;
        }
        
        int total = 0;
        for(int i = n; i >= 0; i--){
            total += bucket[i];
            if(total >= i)
                return i;
        }
        return 0;
    }
}
