package T500_699;

import java.util.HashMap;
import java.util.Map;

public class T663 {
	private Map<Double, Integer> map = new HashMap<>();
    public boolean checkEqualTree(TreeNode root) {
        if(root == null) return false;
        double sum = calculateSum(root);
        if(map.containsKey(sum / 2.0) && sum != 0){
            return true;
        }
        
        if(sum == 0 && map.get(sum) > 1){
            return true;
        }
        
        return false;
    }
    
    private double calculateSum(TreeNode root){
        if(root == null) return 0;
        double sum = calculateSum(root.left) + root.val + calculateSum(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
