package old.T100_199;

public class T167 {
	public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
            return null;
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target)
                left++;
            else if(sum > target)
                right--;
            else{
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[2];
    }
}
