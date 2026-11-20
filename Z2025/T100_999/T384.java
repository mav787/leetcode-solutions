package Z2025.T100_999;

import java.util.*;

public class T384 {
    class Solution {
        private int[] array;
        private int[] original;

        Random rand = new Random();

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public Solution(int[] nums) {
            original = nums;
            array = original.clone();
        }

        public int[] reset() {
            array = original.clone();
            return array;
        }

        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                int index = rand.nextInt(array.length - i) + i;
                swap(array, i, index);
            }
            return array;
        }
    }
}
