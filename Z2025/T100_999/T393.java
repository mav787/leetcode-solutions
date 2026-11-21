package Z2025.T100_999;

import java.util.*;

public class T393 {
    class Solution {
        public boolean validUtf8(int[] data) {
            for(int i = 0; i < data.length; i++){
                int num = data[i];
                if(num >> 7 == 0){
                    continue;
                }
                else if(num >> 5 == 0b110){
                    if(i + 1 >= data.length){
                        return false;
                    }
                    if(data[i + 1] >> 6 == 0b10){
                        i++;
                    }
                    else{
                        return false;
                    }
                }

                else if(num >> 4 == 0b1110){
                    if(i + 2 >= data.length){
                        return false;
                    }
                    if(data[i + 1] >> 6 == 0b10 && data[i + 2] >> 6 == 0b10){
                        i += 2;
                    }
                    else{
                        return false;
                    }
                }
                else if(num >> 3 == 0b11110){
                    if(i + 3 >= data.length){
                        return false;
                    }
                    if(data[i + 1] >> 6 == 0b10 && data[i + 2] >> 6 == 0b10 && data[i + 3] >> 6 == 0b10){
                        i += 3;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }

            return true;
        }
    }

}
