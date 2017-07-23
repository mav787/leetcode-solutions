package T1_99;

public class TT59 {
	public int[][] generateMatrix(int n) {
        if(n <= 0)  
            return new int[0][0];
        int[][] res = new int[n][n];
        int currentnum = 1;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        while(left <= right && up <= down){
            // move right
            for(int i = left; i <= right; i++){
                res[up][i] = currentnum;
                currentnum++;
            }
            up++;
            
            //move down
            for(int i = up; i <= down; i++){
                res[i][right] = currentnum;
                currentnum++;
            }
            right--;
            
            //move left
            if(up <= down){
                for(int i = right; i >= left; i--){
                    res[down][i] = currentnum;
                    currentnum++;
                }
                down--;
            }
            
            // move up
            if(left <= right){
                for(int i = down; i >= up; i--){
                    res[i][left] = currentnum;
                    currentnum++;
                }
                left++;
            }
        }
        return res;
    }
}
