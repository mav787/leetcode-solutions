package Z2025.T100_999;

public class T167 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2){
            return new int[2];
        }

        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left++;
            }
            else if(sum == target){
                return new int[]{left + 1, right + 1};
            }
            else{
                right--;
            }
        }

        return new int[2];
    }
}
