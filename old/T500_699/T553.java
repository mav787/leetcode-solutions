package old.T500_699;

public class T553 {
	public String optimalDivision(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        if(nums.length < 3){
            sb.append(nums[0]);
            for(int i = 1; i < nums.length; i++){
                sb.append("/").append(nums[i]);
            }
            return sb.toString();
        }
        
        sb.append(nums[0]).append("/").append("(");
        for(int i = 1; i < nums.length - 1; i++){
            sb.append(nums[i]).append("/");
        }
        sb.append(nums[nums.length - 1]).append(")");
        return sb.toString();
    }
}
