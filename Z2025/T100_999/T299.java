package Z2025.T100_999;

import java.util.*;

public class T299 {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null || secret.length() != guess.length()){
            return "0A0B";
        }

        int bulls = 0, cows = 0;

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for(int i = 0; i < secret.length(); i++){
            char ca = secret.charAt(i);
            char cb = guess.charAt(i);

            if(ca == cb){
                bulls++;
            }

            mapA.put(ca, mapA.getOrDefault(ca, 0) + 1);
            mapB.put(cb, mapB.getOrDefault(cb, 0) + 1);
        }

        for(char c : mapA.keySet()){
            if(mapB.containsKey(c)){
                cows += Math.min(mapA.get(c), mapB.get(c));
            }
        }

        cows -= bulls;
        return bulls + "A" + cows + "B";
    }
}
