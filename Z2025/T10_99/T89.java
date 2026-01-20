package Z2025.T10_99;
import java.util.*;

public class T89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<Integer>();
        res.add(0);
        for(int i = 0; i < n; i++){
            for(int j = res.size() - 1; j >= 0; j--){
                int num = res.get(j) | (1 << i);
                res.add(num);
            }
        }

        return res;
    }
}
