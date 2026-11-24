package Z2026.Z0;

public class T1534 {
    class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int res = 0;

            for(int i = 0; i < arr.length; i++){
                for(int j = i + 1; j < arr.length; j++){
                    if(Math.abs(arr[i] - arr[j]) > a){
                        continue;
                    }

                    for(int k = j + 1; k < arr.length; k++){
                        if(Math.abs(arr[j] - arr[k]) > b){
                            continue;
                        }
                        if(Math.abs(arr[i] - arr[k]) > c){
                            continue;
                        }

                        res++;
                    }
                }
            }

            return res;
        }
    }

}
