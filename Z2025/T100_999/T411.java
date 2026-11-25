package Z2025.T100_999;

import java.util.*;

public class T411 {
    class Solution {
        public String minAbbreviation(String target, String[] dictionary) {
            List<Integer> diffMasks = new ArrayList<>();

            // Preprocessing: build a diffMask for each word.
            // Bit 0: the character is the same as target.
            // Bit 1: the character is different from target.
            for (String word : dictionary) {
                if (word.length() != target.length()) {
                    continue;
                }

                int diffMask = 0;

                for (int i = 0; i < target.length(); i++) {
                    if (word.charAt(i) != target.charAt(i)) {
                        diffMask |= (1 << i);
                    }
                }

                diffMasks.add(diffMask);
            }

            int minLen = Integer.MAX_VALUE;
            int bestMask = 0;

            // Step 1: brute-force all possible abbreviations using keepMask.
            // Bit 0: abbreviate the character.
            // Bit 1: keep the character.
            // Each character has two choices, so there are 2^n possibilities.
            for (int keepMask = 0; keepMask < (1 << target.length()); keepMask++) {

                // Step 2: validate the abbreviation against all diffMasks.
                // For every dictionary word, we must keep at least one
                // character that is different from target.
                if (!isValid(keepMask, diffMasks)) {
                    continue;
                }

                // Step 3: calculate the abbreviation length
                // and maintain the shortest valid abbreviation.
                int len = getLength(target, keepMask);

                if (len < minLen) {
                    minLen = len;
                    bestMask = keepMask;
                }
            }

            // Convert the best keepMask into an abbreviation string.
            return buildAbbr(target, bestMask);
        }

        private boolean isValid(int keepMask, List<Integer> diffMasks) {
            for (int diffMask : diffMasks) {
                // keepMask: positions we choose to keep.
                // diffMask: positions where the word differs from target.
                //
                // If their intersection is empty, all kept characters
                // match the dictionary word, so the abbreviation is invalid.
                if ((keepMask & diffMask) == 0) {
                    return false;
                }
            }

            return true;
        }

        private int getLength(String target, int keepMask) {
            int len = 0;
            int count = 0;

            for (int i = 0; i < target.length(); i++) {
                if ((keepMask & (1 << i)) == 0) {
                    // Abbreviate the current character.
                    count++;
                } else {
                    // Keep the current character.

                    // Flush count: a consecutive group of abbreviated
                    // characters contributes one unit to the length.
                    if (count != 0) {
                        len++;
                        count = 0;
                    }

                    // The kept character contributes one unit.
                    len++;
                }
            }

            // Flush trailing abbreviated characters.
            if (count != 0) {
                len++;
            }

            return len;
        }

        private String buildAbbr(String target, int keepMask) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int i = 0; i < target.length(); i++) {
                if ((keepMask & (1 << i)) == 0) {
                    // Abbreviate the current character.
                    count++;
                } else {
                    // Flush count before keeping the current character.
                    if (count != 0) {
                        sb.append(count);
                        count = 0;
                    }

                    sb.append(target.charAt(i));
                }
            }

            // Flush trailing abbreviated characters.
            if (count != 0) {
                sb.append(count);
            }

            return sb.toString();
        }
    }

}
