package Z2025.T100_999;

import java.util.*;

public class T380 {
    class RandomizedSet {
        Map<Integer, Integer> indexToKey;
        Map<Integer, Integer> keyToIndex;
        Random random;
        int size;


        public RandomizedSet() {
            indexToKey = new HashMap<>();
            keyToIndex = new HashMap<>();
            size = 0;
            random = new Random();
        }

        public boolean insert(int val) {
            if(keyToIndex.containsKey(val)){
                return false;
            }

            indexToKey.put(size, val);
            keyToIndex.put(val, size);

            size++;
            return true;
        }

        public boolean remove(int val) {
            if(!keyToIndex.containsKey(val)){
                return false;
            }

            int key = val;
            int index = keyToIndex.get(key);

            int tailIndex = size - 1;
            int tailKey = indexToKey.get(tailIndex);

            indexToKey.put(index, tailKey);
            keyToIndex.put(tailKey, index);

            indexToKey.remove(tailIndex);
            keyToIndex.remove(key);

            size--;
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(size);
            return indexToKey.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
