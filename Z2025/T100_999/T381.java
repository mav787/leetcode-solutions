package Z2025.T100_999;

import java.util.*;

public class T381 {
    class RandomizedCollection {
        Random random;
        List<Integer> list;
        Map<Integer, Set<Integer>> map;


        public RandomizedCollection() {
            random = new Random();
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            boolean res = !map.containsKey(val);
            if(res){
                map.put(val, new HashSet<>());
            }

            Set<Integer> indices = map.get(val);
            indices.add(list.size());

            list.add(val);
            return res;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }

            Set<Integer> indices = map.get(val);
            int index = indices.iterator().next();

            indices.remove(index);
            if(indices.isEmpty()){
                map.remove(val);
            }

            int tailIndex = list.size() - 1;
            int tailVal = list.get(tailIndex);

            if(map.containsKey(tailVal)){
                Set<Integer> tailIndices = map.get(tailVal);
                tailIndices.add(index);
                tailIndices.remove(tailIndex);
            }

            list.set(index, tailVal);
            list.remove(tailIndex);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
