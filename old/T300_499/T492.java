package old.T300_499;

public class T492 {
	public int[] constructRectangle(int area) {
        if(area <= 0) return new int[2];
        int L = area, W = 1;
        for(int i = 1; i <= (int)Math.sqrt(area); i++){
            if(area % i == 0){
                W = i;
                L = area / i;
            }
        }
        
        return new int[]{L, W};
    }
}
