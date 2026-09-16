package Z2025.T100_999;

import java.util.*;

public class T293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < currentState.length() - 1; i++){
            String sub = currentState.substring(i, i + 2);
            if(sub.equals("++")){
                res.add(currentState.substring(0, i) + "--" + currentState.substring(i + 2));
            }
        }
        return res;
    }
}
