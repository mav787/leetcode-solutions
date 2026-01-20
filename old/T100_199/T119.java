package old.T100_199;
import java.util.*;

public class T119 {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0)
            return res;
        rowIndex = rowIndex + 1;
        List<Integer> former = new ArrayList<>();
        for(int i = 1; i <= rowIndex; i++){
            former = res;
            res = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                if(j == 1 || j == i)
                    res.add(1);
                else{
                    res.add(former.get(j - 2) + former.get(j - 1));
                }
            }
        }
        return res;
    }
}
