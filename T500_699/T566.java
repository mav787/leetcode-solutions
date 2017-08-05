package T500_699;

public class T566 {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if(m * n != r * c){
            return nums;
        }
        
        int[][] res = new int[r][c];
        for(int i = 0; i < r * c; i++){
            res[i / c][i % c] = nums[i / n][i % n];    
        }
        return res;
    }
}
