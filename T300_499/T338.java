package T300_499;

import java.util.*;

public class T338 {
	public int[] countBits(int num) {
        if(num < 0){
            return null;
        }
        int[] res= new int[num + 1];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        while(list.size() < num + 1){
            int size = list.size();
            for(int i = 0; i < size; i++){
                if(list.size() >= num + 1){
                    break;
                }
                list.add(list.get(i) + 1);
            }
        }
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
