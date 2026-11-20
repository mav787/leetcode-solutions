package Z2025.T100_999;

import java.util.*;

public class T379 {
    class PhoneDirectory {
        Set<Integer> available;

        public PhoneDirectory(int maxNumbers) {
            available = new HashSet<>();

            for(int i = 0; i < maxNumbers; i++){
                available.add(i);
            }
        }

        public int get() {
            if(available.isEmpty()){
                return -1;
            }

            int num = 0;
            for(int number : available){
                num = number;
                break;
            }

            available.remove(num);
            return num;
        }

        public boolean check(int number) {
            return available.contains(number);
        }

        public void release(int number) {
            available.add(number);
        }
    }

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */

}
