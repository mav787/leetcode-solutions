package T500_699;
import java.util.*;
public class T554 {
	public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> level : wall){
            int index = 0;
            for(int i = 0; i < level.size() - 1; i++){
                index += level.get(i);
                map.put(index, map.getOrDefault(index, 0) + 1);
            }
        }
        int border = 0;
        for(Integer key : map.keySet()){
            border = Math.max(border, map.get(key));
        }
        return wall.size() - border;
    }
}
