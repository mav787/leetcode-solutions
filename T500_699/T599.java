package T500_699;
import java.util.*;

public class T599 {
	public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        if(list1 == null || list1.length == 0 || list2 == null || list2.length == 0) return new String[0];
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int sum = map.get(list2[i]) + i;
                if(sum < min){
                    res = new ArrayList<>();
                    res.add(list2[i]);
                    min = sum;
                }
                else if(sum == min){
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
