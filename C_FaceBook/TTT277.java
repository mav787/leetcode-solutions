package C_FaceBook;

public class TTT277 {
	public int findCelebrity(int n) {
        if(n - 1 <= 0) return -1;
        int candidate = 0;
        for(int i = 0; i < n; i++){
            if(i != candidate){
                if(knows(candidate, i)){
                    candidate = i;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != candidate){
                if(knows(candidate, i) || !knows(i, candidate)) return -1;
            }
        }
        return candidate;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean knows(int a, int b){
		return false;
	}
}
