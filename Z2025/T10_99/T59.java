package Z2025.T10_99;

public class T59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int curr = 1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                res[top][i] = curr;
                curr++;
            }
            top++;

            for(int i = top; i <= bottom; i++){
                res[i][right] = curr;
                curr++;
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    res[bottom][i] = curr;
                    curr++;
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    res[i][left] = curr;
                    curr++;
                }
                left++;
            }
        }

        return res;
    }
}
