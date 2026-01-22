package Z2025.T100_999;
import java.util.*;

public class T119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        int n = rowIndex;

        prev.add(1);
        if(n == 0){
            return prev;
        }

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    curr.add(1);
                }
                else{
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
            }
            prev = curr;
            curr = new ArrayList<>();
        }

        return prev;
    }
}
