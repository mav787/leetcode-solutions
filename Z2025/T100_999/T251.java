package Z2025.T100_999;
import java.util.*;

public class T251 {
    List<Integer> list;
    int curr;

    public T251(int[][] vec) {
        curr = 0;
        list = new ArrayList<>();
        for(int i = 0; i < vec.length; i++){
            for(int j = 0; j < vec[i].length; j++){
                list.add(vec[i][j]);
            }
        }
    }

    public int next() {
        int res = list.get(curr);
        curr++;
        return res;
    }

    public boolean hasNext() {
        return curr < list.size();
    }
}
