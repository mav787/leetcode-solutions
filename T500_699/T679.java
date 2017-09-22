package T500_699;
import java.util.*;
public class T679 {
//	
//	public boolean judgePoint24(int[] nums) {
//        double[] set = new double[4];
//        for (int i = 0; i < 4; i ++)
//            set[i] = nums[i];
//        return judgePoint24(set);
//    }
//	
//	
//	private boolean judgePoint24(double[] nums) {
//        int len = nums.length;
//        if (len == 1)
//            return nums[0] == 24;
//
//        double[] nextNums = new double[len - 1];
//
//        for (int i = 0; i < len; i ++)
//            for (int j = i + 1; j < len; j ++) {
//                int index = 0;
//                for (int k = 0; k < len; k ++)
//                    if (k != i && k != j)
//                        nextNums[index ++] = nums[k];
//
//                nextNums[index] = nums[i] + nums[j];
//                if (judgePoint24(nextNums)) return true;
//                nextNums[index] = nums[i] - nums[j];
//                if (judgePoint24(nextNums)) return true;
//                nextNums[index] = -nums[i] + nums[j];
//                if (judgePoint24(nextNums)) return true;
//                nextNums[index] = nums[i] * nums[j];
//                if (judgePoint24(nextNums)) return true;
//                if (nums[j] != 0) {
//                    nextNums[index] = nums[i] / nums[j];
//                    if (judgePoint24(nextNums)) return true;
//                }
//                if (nums[i] != 0) {
//                    nextNums[index] = nums[j] / nums[i];
//                    if (judgePoint24(nextNums)) return true;
//                }
//            }
//        return false;
//    }

    
    
	public boolean judgePoint24(int[] nums) {
        if(nums == null || nums.length != 4) return false;
        boolean[] used = new boolean[nums.length];
        return (backtrack(nums, used, 0, 0));
    }
    
    private boolean backtrack(int[] nums, boolean[] used, double val, int numsUsed){
        if(numsUsed == used.length){
            if(val == 24) return true;
            return false;
        } 
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            // using nums[i]
            if(backtrack(nums, used, val + nums[i], numsUsed + 1)) return true;
            if(backtrack(nums, used, val - nums[i], numsUsed + 1)) return true;
            if(backtrack(nums, used, nums[i] - val, numsUsed + 1)) return true;
            if(numsUsed != 0 && backtrack(nums, used, nums[i] * val, numsUsed + 1)) return true;
            if(val != 0 && backtrack(nums, used, nums[i] / val, numsUsed + 1)) return true;
            if(numsUsed != 0 && backtrack(nums, used, val / nums[i], numsUsed + 1)) return true;
            //back
            used[i] = false;
        }
        
        if(numsUsed == 2){
            // condition....
            List<Double> l1 = new ArrayList<>(), l2 = new ArrayList<>();
            for(int i = 0; i < used.length; i++){
                if(used[i]) l1.add((double) nums[i]);
                else l2.add((double) nums[i]);
            }
            List<Double> inter1 = computeInter(l1), inter2 = computeInter(l2);
            //inter1.addAll(inter2);
            List<Double> res = computeInter(inter1, inter2);
            for(double item : res){
                if (item == 24) return true;
            }
        }
        return false;
    }
    
    private List<Double> computeInter(List<Double> input){
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < input.size(); i++){
            for(int j = i + 1; j < input.size(); j++){
                double d1 = input.get(i);
                double d2 = input.get(j);
                res.add(d1 + d2);
                res.add(d1 - d2);
                res.add(d2 - d1);
                res.add(d1 * d2);
                if(d2 != 0) res.add(d1 / d2);
                if(d1 != 0) res.add(d2 / d1);
            }
        }
        return res;
    }
    
    private List<Double> computeInter(List<Double> l1, List<Double> l2){
    	List<Double> res = new ArrayList<>();
    	for(double d1 : l1){
    		for(double d2 : l2){
    			res.add(d1 + d2);
                res.add(d1 - d2);
                res.add(d2 - d1);
                res.add(d1 * d2);
                if(d2 != 0) res.add(d1 / d2);
                if(d1 != 0) res.add(d2 / d1);
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	T679 obj = new T679();
    	System.out.println(obj.judgePoint24(new int[]{1,5,9,1}));
    }
}
