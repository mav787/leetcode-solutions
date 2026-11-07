package Z2025.T100_999;

import java.util.*;

public class T331 {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty()){
            return false;
        }

        String[] sa = preorder.split(",");

        int slots = 1;
        for(int i = 0; i < sa.length; i++){
            if(slots == 0){
                return false;
            }
            if(sa[i].equals("#")){
                slots--;
            }
            else{
                slots++;
            }
        }

        return slots == 0;
    }

}
