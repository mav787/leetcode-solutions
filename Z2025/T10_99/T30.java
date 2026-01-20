package Z2025.T10_99;
import java.util.*;


public class T30 {
    class Solution {

        public List<Integer> findSubstring(String s, String[] words) {
            int n = s.length();
            List<Integer> res = new ArrayList<>();

            if (words.length == 0) {
                return res;
            }

            int wordLen = words[0].length();
            if (n < wordLen * words.length) {
                return res;
            }

            int lastStart = n - wordLen + 1;

            // map each word to an id, and build target counts
            Map<String, Integer> map = new HashMap<>();
            int[][] countTable = new int[2][words.length];

            int missingTypes = 0;
            int nextId = 0;

            for (int i = 0; i < words.length; i++) {
                Integer id = map.get(words[i]);
                if (id == null) {
                    missingTypes++;
                    map.put(words[i], nextId);
                    id = nextId;
                    nextId++;
                }
                countTable[0][id]++;
            }

            // map each substring in s to its word id, -1 means not in words
            int[] sMap = new int[lastStart];
            for (int i = 0; i < lastStart; i++) {
                String section = s.substring(i, i + wordLen);
                Integer id = map.get(section);
                if (id == null) {
                    sMap[i] = -1;
                } else {
                    sMap[i] = id;
                }
            }

            // scan M offsets
            for (int i = 0; i < wordLen; i++) {
                int currMissingTypes = missingTypes;
                int left = i;
                int right = i;

                Arrays.fill(countTable[1], 0);

                while (right < lastStart) {
                    while (currMissingTypes > 0 && right < lastStart) {
                        int target = sMap[right];
                        if (target != -1) {
                            countTable[1][target]++;
                            if (countTable[1][target] == countTable[0][target]) {
                                currMissingTypes--;
                            }
                        }
                        right += wordLen;
                    }

                    while (currMissingTypes == 0 && left < right) {
                        int target = sMap[left];
                        if (target != -1) {
                            countTable[1][target]--;
                            if (countTable[1][target] == countTable[0][target] - 1) {
                                int length = right - left;
                                if ((length / wordLen) == words.length) {
                                    res.add(left);
                                }
                                currMissingTypes++;
                            }
                        }
                        left += wordLen;
                    }
                }
            }

            return res;
        }
    }

}
