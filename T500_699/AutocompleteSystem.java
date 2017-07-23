package T500_699;
import java.util.*;

public class AutocompleteSystem {

    private Trie trie = new Trie();
    private StringBuilder prefix = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            trie.add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            trie.add(prefix.toString(), 1);
            prefix.setLength(0);
            return Collections.emptyList();
        }
        prefix.append(c);
        List<TaggedString> taggedStrings = trie.getWords(prefix.toString());
        Collections.sort(taggedStrings);
        List<String> best = new ArrayList<>();
        for (int i = taggedStrings.size() - 1; i >= Math.max(taggedStrings.size() - 3, 0); i--) {
            best.add(taggedStrings.get(i).string);
        }
        return best;
    }

    private class TaggedString implements Comparable<TaggedString> {
        private String string;
        private int tag;

        TaggedString(String string, int tag) {
            this.string = string;
            this.tag = tag;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            TaggedString that = (TaggedString) other;
            return tag == that.tag && (string != null ? string.equals(that.string) : that.string == null);
        }

        @Override
        public int hashCode() {
            int result = string != null ? string.hashCode() : 0;
            result = 31 * result + tag;
            return result;
        }

        @Override
        public int compareTo(TaggedString other) {
            int comparison = Integer.compare(tag, other.tag);
            if (comparison == 0) {
                return -string.compareTo(other.string);
            }
            return comparison;
        }
    }

    class Trie {
        private static final int ALPHABET_SIZE = 27;
        private final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
        private Trie[] tries = new Trie[ALPHABET_SIZE];
        private int occurrences = 0;

        void add(String string, int count) {
            add(string, count, 0);
        }

        private void add(String string, int count, int index) {
            if (index < string.length()) {
                int trieIndex = toTrieIndex(string.charAt(index));
                if (tries[trieIndex] == null) {
                    tries[trieIndex] = new Trie();
                }
                tries[trieIndex].add(string, count, index + 1);
            } else {
                occurrences += count;
            }
        }

        List<TaggedString> getWords(String prefix) {
            return getWords(prefix, 0);
        }

        private List<TaggedString> getWords(String prefix, int index) {
            if (index < prefix.length()) {
                if (tries[toTrieIndex(prefix.charAt(index))] != null) {
                    return tries[toTrieIndex(prefix.charAt(index))].getWords(prefix, index + 1);
                }
                return Collections.emptyList();
            }
            // Make a list of words.
            List<TaggedString> words = new ArrayList<>();
            getAllWords(words, new StringBuilder(prefix));
            return words;
        }

        private int toTrieIndex(char character) {
            if (character == ' ') {
                return 26;
            }
            return character - 'a';
        }

        private void getAllWords(List<TaggedString> words, StringBuilder builder) {
            if (occurrences > 0) {
                words.add(new TaggedString(builder.toString(), occurrences));
            }
            for (char character : CHARACTERS) {
                Trie trie = tries[toTrieIndex(character)];
                if (trie != null) {
                    // Push the new character into the string we are creating.
                    builder.append(character);
                    // Recurse.
                    trie.getAllWords(words, builder);
                    // Pop the current character.
                    builder.setLength(builder.length() - 1);
                }
            }
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Trie trie = (Trie) other;
            return occurrences == trie.occurrences && Arrays.equals(tries, trie.tries);
        }

    }

}