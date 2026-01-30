package Z2025.T100_999;
import java.util.*;

public class T170 {
    Map<Integer, Integer> map;

    public T170() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for(int key : map.keySet()){
            int counter = value - key;
            if(map.containsKey(counter)){
                if(counter != key){
                    return true;
                }
                else{
                    if (map.get(key) > 1){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
