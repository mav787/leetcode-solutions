package Z2025.T100_999;

import java.util.*;

public class T359 {
    class Logger {
        Map<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!map.containsKey(message) || timestamp - map.get(message) >= 10){
                map.put(message, timestamp);
                return true;
            }
            else{
                return false;
            }
        }
    }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}
